package eva_andres.demo.repository

import eva_andres.demo.model.Vehiculo


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ReservaRepository:JpaRepository<Vehiculo, Long> {

    fun findById(id: Long?):Vehiculo
    @Query(nativeQuery = true)
    fun findTotalMoreThan(@Param ("total") total: Double?):List<Vehiculo>?}