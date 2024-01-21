package org.ivdev.service.impl

import org.ivdev.dto.CountryDTO
import org.ivdev.entity.CountryEntity
import org.ivdev.repo.CountryRepo
import org.ivdev.service.CountryService
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

/*
Инжектим в конструктор созданый репозиторий.
* Метод getAll() возвращает все сущности, смапленные в DTO.
Рекомендуется сразу разделять DTO и Entity в реальных приложениях, набор полей может различаться.
(с)Devmark
* */
@Service
class CountryServiceImpl(
    private val countryRepo: CountryRepo,
) : CountryService {
    override fun getAll(pageIndex: Int): List<CountryDTO> {
        return countryRepo.findByOrderByName(PageRequest.of(pageIndex, 2))
            .map { it.toDto() }
    }

    //класс расширения позволяет вынести логику мапинга полей из основного метода сервиса
    private fun CountryEntity.toDto(): CountryDTO =
        CountryDTO(
            id = this.id,
            name = this.name,
            population = this.population
        )
}