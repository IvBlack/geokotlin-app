package org.ivdev.service.impl

import org.ivdev.dto.CountryDTO
import org.ivdev.service.CountryService
import org.springframework.stereotype.Service

@Service
class CountryServiceImpl : CountryService {
    override fun getAll(): List<CountryDTO> {
        return listOf(
            CountryDTO(1, "Germany", 1_458_560),
            CountryDTO(2, "RF", 140_000_450)
        )
    }
}