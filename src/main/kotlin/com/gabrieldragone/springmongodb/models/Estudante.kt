package com.gabrieldragone.springmongodb.models

import com.gabrieldragone.springmongodb.enums.Genero
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime

@Document
data class Estudante (
    @Id
    var id: String? = null,
    var primeiroNome: String? = null,
    var ultimoNome: String? = null,
    @Indexed(unique = true) // O index melhora o desempenho das consultas e o unique informa que não podem haver emails repetidos
    var email: String? = null,
    var genero: Genero? = null,
    var endereco: Endereco? = null,
    var temasFavoritos: List<String>? = null,
    var totalGastoEmLivros: BigDecimal? = null,
    var dataCriacao: LocalDateTime? = null
)