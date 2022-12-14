package eva_andres.demo.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name="Detail")
class Servicio {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column (name="invoice_id")
    var invoiceId: Long? = null
    @Column (name="product_id")
    var productId: Long? = null
    var quantity: Long? = null


}