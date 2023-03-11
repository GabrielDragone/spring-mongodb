package com.gabrieldragone.springmongodb.services

import com.gabrieldragone.springmongodb.exceptions.EmailJaCadastradoException
import com.gabrieldragone.springmongodb.models.Estudante
import com.gabrieldragone.springmongodb.repositories.EstudanteRepository
import org.slf4j.LoggerFactory
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service

@Service
class EstudanteService(
    private val repository: EstudanteRepository,
    val mongoTemplate: MongoTemplate) {

    private val LOGGER = LoggerFactory.getLogger(EstudanteService::class.java)

    fun listarTodos(): List<Estudante>? {
        return repository.findAll()
    }

    fun salvar(estudante: Estudante): Estudante {
        LOGGER.info("Salvando registro de Estudante")

        //verificarSeEstudanteExisteComEmailUtilizandoMongoTemplate(estudante)
        verificarSeEstudanteExisteComEmailUtilizandoRepository(estudante.email)

        val estudanteSalvo = repository.insert(estudante)
        return estudanteSalvo

    }

    // Exemplo utilizando Respository com JPA:
    fun verificarSeEstudanteExisteComEmailUtilizandoRepository(email: String?) {
        repository.findEstudanteByEmail(email).ifPresentOrElse({
            throw EmailJaCadastradoException("Já existe um estudante com o e-mail $email cadastrado!")
        }, {
            LOGGER.info("E-mail validado com sucesso!")
        })
    }

    // Exemplo usando MongoTemplate, sem usar o EstudanteRepository:
    private fun verificarSeEstudanteExisteComEmailUtilizandoMongoTemplate(email: String) {
        val query = Query()
        query.addCriteria(Criteria.where("email").`is`(email))
        val estudantesComMesmoEmail: List<Estudante> = mongoTemplate.find(query)

        if (estudantesComMesmoEmail.size > 1) {
            throw EmailJaCadastradoException("Foram encontrados mais de 1 estudante com mesmo e-mail $email!")
        }

        if (!estudantesComMesmoEmail.isEmpty()) {
            throw EmailJaCadastradoException("Já existe um estudante com o e-mail $email cadastrado!")
        }
    }

    fun deletar(id: String) {
        repository.deleteById(id)
    }

}