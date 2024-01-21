package org.ivdev.service

import org.ivdev.dto.CountryDTO
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service

@Service
interface CountryService {
    fun getAll(pageIndex: Int): List<CountryDTO>
    fun getById(id: Int): CountryDTO
    fun search(prefix: String): List<CountryDTO>
}