package eva_andres.demo.service

import eva_andres.demo.model.Cliente
import eva_andres.demo.repository.VehiculoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ClienteService {

    @Autowired
    lateinit var asistenteRepository: VehiculoRepository

    fun list():List<Cliente>{
        return asistenteRepository.findAll()
    }
    fun listById (id: Long?): VehiculoRepository{
        return asistenteRepository.findById(id)
    }

    fun save(asistente:Cliente):Cliente{
        return asistenteRepository.save(asistente)

    }

    fun update(asistente: Cliente):Cliente{
        try{
            asistenteRepository.findById(asistente.id)
                ?: throw Exception("ID no existe")
            return asistenteRepository.save(asistente)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(asistente:Cliente): Cliente{
        try{
            val response = asistenteRepository.findById(asistente.id)
                ?: throw Exception("ID no existe")
            response.apply {
                nombres=asistente.nombres

            }
            return asistenteRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}