package dev.dead.spring6webapp.controller

import dev.dead.spring6webapp.service.KotlinService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KotlinController(private val KotlinService: KotlinService) {
    @GetMapping("/kotlin")
    fun kotlin(): String? {
        return KotlinService.get()?.name;
    }

    @GetMapping("hellokotlin")
    fun helloKotlin(): ResponseEntity<String>? =
        ResponseEntity("hello kotlin", HttpStatus.OK)
}