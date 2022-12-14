package eva_andres.demo.repository

import eva_andres.demo.model.Reserva


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository:JpaRepository<Reserva, Long> {

    fun findById(id: Long?):Reserva
}