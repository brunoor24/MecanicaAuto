package eva_andres.demo.repository

import eva_andres.demo.model.Servicio


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ServicioRepository:JpaRepository<Servicio, Long> {

    fun findById(id: Long?):Servicio?
    @Query(nativeQuery =true)
    fun sumTotal(@Param ("invoiceId") invoiceId: Long?): Double?






}

