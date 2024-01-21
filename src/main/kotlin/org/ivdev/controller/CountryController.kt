package org.ivdev.controller

import org.springframework.web.bind.annotation.RestController
import org.ivdev.dto.CountryDTO
import org.ivdev.service.CountryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RestController
@RequestMapping("/countries")
class CountryController(

    //spring uses interface injection, to steer clear off realisation
    private val countryService: CountryService
) {
    //pagination is through RequestParam: http://.../countries?page=1
    @GetMapping
    fun getAll(@RequestParam("page") pageIndex: Int): List<CountryDTO> =
        countryService.getAll(pageIndex)
}