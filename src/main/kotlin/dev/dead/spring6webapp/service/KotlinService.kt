package dev.dead.spring6webapp.service

import dev.dead.spring6webapp.domain.KotlinDomain
import dev.dead.spring6webapp.repository.KotlinRepository
import org.springframework.stereotype.Service

@Service
class KotlinService(private val repository: KotlinRepository) {
    fun get(): KotlinDomain? {
        return repository.getBy()
    }

}