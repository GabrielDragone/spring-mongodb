package com.gabrieldragone.springmongodb.repositories

import com.gabrieldragone.springmongodb.models.Estudante
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface EstudanteRepository: MongoRepository<Estudante, String> {

    fun findEstudanteByEmail(email: String?): Optional<Estudante>

//    @Query("")
//    fun teste()

}