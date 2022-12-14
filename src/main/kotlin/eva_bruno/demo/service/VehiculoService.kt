package eva_andres.demo.service

import eva_andres.demo.model.Servicio
import eva_andres.demo.model.Reserva
import eva_andres.demo.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class VehiculoService {
    @Autowired
    lateinit var productRepository: ClienteRepository
    @Autowired
    lateinit var detailRepository: ServicioRepository
    @Autowired
    lateinit var invoiceRepository: ReservaRepository

    fun list():List<Servicio>{
        return detailRepository.findAll()
    }


    fun save(detail:Servicio):Servicio{

        try{
            val response=detailRepository.save(detail)
            val responseProduct: Reserva = productRepository.findById(response.productId)
            responseProduct.apply {
                stock = stock?.minus(detail.quantity!!)
            }
            productRepository.save(responseProduct)
            calculateAndUpdateTotal(response)

            return response
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }

    fun update(detail: Servicio):Servicio{
        try{
            detailRepository.findById(detail.id)
                ?: throw Exception("ID no existe")
            return detailRepository.save(detail)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updatequantity(detail:Servicio): Servicio{
        try{
            val response = detailRepository.findById(detail.id)
                ?: throw Exception("ID no existe")
            response.apply {
                quantity=detail.quantity

            }
            return detailRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun calculateAndUpdateTotal (detail : Servicio){
        val totalCalculated = detailRepository.sumTotal(detail.invoiceId)
        val invoiceResponse = invoiceRepository.findById(detail.invoiceId)
        invoiceResponse.apply {
            total=totalCalculated
        }
        invoiceRepository.save(invoiceResponse)
    }

}
