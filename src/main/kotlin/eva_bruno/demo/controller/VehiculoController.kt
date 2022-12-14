package eva_andres.demo.controller


import eva_andres.demo.model.Reserva
import eva_andres.demo.service.ServicioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/product")
class VehiculoController {

    @Autowired
    lateinit var productService: ServicioService

    @GetMapping
    fun list():List<Reserva>{
        return productService.list()
    }

    @PostMapping
    fun save(@RequestBody product: Reserva):Reserva{
        return productService.save(product)
    }

    @PutMapping
    fun update (@RequestBody product: Reserva): ResponseEntity<Reserva>{
        return ResponseEntity(productService.update(product),HttpStatus.OK )
    }

    @PatchMapping
    fun updateStock (@RequestBody product:Reserva):ResponseEntity<Reserva>{
        return ResponseEntity(productService.updateStock(product), HttpStatus.OK)
    }

}