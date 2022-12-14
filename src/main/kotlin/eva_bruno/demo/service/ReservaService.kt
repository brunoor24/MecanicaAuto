package eva_andres.demo.service

import eva_andres.demo.model.Vehiculo
import eva_andres.demo.repository.VehiculoRepository
import eva_andres.demo.repository.ReservaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ReservaService {
    @Autowired
    lateinit var asistenteRepository: VehiculoRepository
    @Autowired
    lateinit var invoiceRepository: ReservaRepository

    fun list():List<Vehiculo>{
        return invoiceRepository.findAll()
    }
    fun listTotalMoreThan(total:Double?): List<Vehiculo>? {
        return invoiceRepository.findTotalMoreThan(total)
    }

    fun save(invoice:Vehiculo):Vehiculo{
        try{
            asistenteRepository.findById(invoice.asistenteId)
                ?: throw Exception("asistente no existe")
            return invoiceRepository.save(invoice)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }





    fun update(invoice: Vehiculo):Vehiculo{
        try{
            invoiceRepository.findById(invoice.id)
                ?: throw Exception("ID no existe")
            return invoiceRepository.save(invoice)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateTotal(invoice: Vehiculo): Vehiculo {
        try{
            val response = invoiceRepository.findById(invoice.id)
                ?: throw Exception("ID no existe")
            response.apply {
                total=invoice.total
            }
            return invoiceRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}