package org.ivdev.controller

import org.springframework.web.bind.annotation.RestController
import org.ivdev.dto.CountryDTO
import org.ivdev.service.CountryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/countries")
class CountryController(

    //spring uses interface injection, to steer clear off realisation
    private val countryService: CountryService
) {
    @GetMapping
    fun getAll(): List<CountryDTO> = countryService.getAll()
}