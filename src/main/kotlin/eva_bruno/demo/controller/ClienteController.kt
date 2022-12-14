package eva_andres.demo.controller

import eva_andres.demo.model.Cliente
import eva_andres.demo.service.ClienteService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/asistente")
class ClienteController {

    @Autowired
    lateinit var asistenteService: ClienteService

    @GetMapping
    fun list():List<Cliente>{
        return asistenteService.list()
    }

    @PostMapping
    fun save(@RequestBody @Valid asistente: Cliente):Cliente{
        return asistenteService.save(asistente)
    }

    @PutMapping
    fun update (@RequestBody asistente: Cliente): ResponseEntity<Cliente>{
        return ResponseEntity(asistenteService.update(asistente),HttpStatus.OK )
    }

    @PatchMapping
    fun updateName (@RequestBody asistente:Cliente):ResponseEntity<Cliente>{
        return ResponseEntity(asistenteService.updateName(asistente), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable ("id") id: Long):ResponseEntity<Cliente>{
        return ResponseEntity(asistenteService .listById(id), HttpStatus.OK)
    }

}