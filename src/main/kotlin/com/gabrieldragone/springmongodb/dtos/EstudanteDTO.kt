package com.gabrieldragone.springmongodb.dtos

import com.gabrieldragone.springmongodb.enums.Genero
import com.gabrieldragone.springmongodb.models.Endereco
import java.math.BigDecimal
import java.time.LocalDateTime

data class EstudanteDTO (
    var primeiroNome: String?,
    var ultimoNome: String?,
    var email: String,
    var genero: Genero?,
    var endereco: Endereco?,
    var temasFavoritos: List<String>?,
    var totalGastoEmLivros: BigDecimal?
)