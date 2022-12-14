package eva_andres.demo.controller

import eva_andres.demo.model.Vehiculo
import eva_andres.demo.service.ReservaService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invoice")
class ServicioController {

    @Autowired
    lateinit var invoiceService: ReservaService

    @GetMapping
    fun list():List<Vehiculo>{
        return invoiceService.list()
    }
    @GetMapping("/totals/{total}")
    fun listTotals (@PathVariable("total") total: Double ):ResponseEntity<*>{
        return ResponseEntity(invoiceService.listTotalMoreThan(total), HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody invoice: Vehiculo):Vehiculo{
        return invoiceService.save(invoice)
    }

    @PutMapping
    fun update (@RequestBody invoice: Vehiculo): ResponseEntity<Vehiculo>{
        return ResponseEntity(invoiceService.update(invoice),HttpStatus.OK )
    }

    @PatchMapping
    fun updateName (@RequestBody invoice:Vehiculo):ResponseEntity<Vehiculo>{
        return ResponseEntity(invoiceService.updateTotal(invoice), HttpStatus.OK)
    }

}