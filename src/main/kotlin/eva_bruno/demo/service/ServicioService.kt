package eva_andres.demo.service

import eva_andres.demo.model.Reserva
import eva_andres.demo.repository.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ServicioService {

    @Autowired
    lateinit var productRepository: ClienteRepository

    fun list():List<Reserva>{
        return productRepository.findAll()
    }

    fun save(product:Reserva):Reserva{
        return productRepository.save(product)

    }

    fun update(product: Reserva):Reserva{
        try{
            productRepository.findById(product.id)
                ?: throw Exception("ID no existe")
            return productRepository.save(product)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateStock(product:Reserva):Reserva{
        try{
            val response =  productRepository.findById(product.id)
                ?: throw Exception("ID no existe")
            response.apply {
                stock =product.stock

            }
            return productRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}