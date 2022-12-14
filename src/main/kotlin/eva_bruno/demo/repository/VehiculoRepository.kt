package eva_andres.demo.repository

import eva_andres.demo.model.Cliente


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VehiculoRepository:JpaRepository<Cliente, Long> {

    fun findById(id: Long?):Cliente
}