package dev.dead.spring6webapp.repository

import dev.dead.spring6webapp.domain.KotlinDomain
import org.springframework.data.jpa.repository.JpaRepository

interface KotlinRepository
    : JpaRepository<KotlinDomain, Long> {
    fun getBy(): KotlinDomain?
}