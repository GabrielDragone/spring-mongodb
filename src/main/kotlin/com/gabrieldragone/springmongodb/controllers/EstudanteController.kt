package com.gabrieldragone.springmongodb.controllers

import com.gabrieldragone.springmongodb.dtos.EstudanteDTO
import com.gabrieldragone.springmongodb.models.Estudante
import com.gabrieldragone.springmongodb.services.EstudanteService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.BeanUtils
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@RestController
@RequestMapping("/api/v1/estudantes")
class EstudanteController(private val service: EstudanteService) {

    @GetMapping
    @Operation(description = "Endpoint para retornar todos os Estudantes cadastrados")
    fun listarTodos(): ResponseEntity<List<Estudante>> {
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos())
    }

    @PostMapping
    @Operation(description = "Endpoint para cadastro de Estudante")
    fun salvar(@RequestBody dto: EstudanteDTO): ResponseEntity<Any> {
        val estudante = Estudante()
        BeanUtils.copyProperties(dto, estudante)
        estudante.dataCriacao = LocalDateTime.now()
        val estudanteSalvo = service.salvar(estudante)
        return ResponseEntity.status(HttpStatus.CREATED).body(estudanteSalvo)
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Endpoint para remover Estudante por id")
    fun deletar(@PathVariable(value = "id") id: String): ResponseEntity<Any> {
        service.deletar(id)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Registro removido com sucesso!")
    }

}