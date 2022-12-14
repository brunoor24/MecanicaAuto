package eva_andres.demo.controller


import eva_andres.demo.model.Servicio
import eva_andres.demo.service.VehiculoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/detail")
class ReservaController {

    @Autowired
    lateinit var detailService: VehiculoService

    @GetMapping
    fun list():List<Servicio>{
        return detailService.list()
    }

    @PostMapping
    fun save(@RequestBody detail: Servicio):Servicio{
        return detailService.save(detail)
    }

    @PutMapping
    fun update (@RequestBody detail: Servicio): ResponseEntity<Servicio>{
        return ResponseEntity(detailService.update(detail),HttpStatus.OK )
    }

    @PatchMapping
    fun updateStock (@RequestBody detail:Servicio):ResponseEntity<Servicio>{
        return ResponseEntity(detailService.updatequantity(detail), HttpStatus.OK)
    }

}