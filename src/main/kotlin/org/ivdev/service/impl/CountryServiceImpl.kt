package org.ivdev.service.impl

import org.ivdev.dto.CountryDTO
import org.ivdev.entity.CountryEntity
import org.ivdev.repo.CountryRepo
import org.ivdev.service.CountryService
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping

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

    //поиск сущности по id, мапинг в DTO на лету, Elvis-оператор в случае неудачи
    override fun getById(id: Int): CountryDTO {
        return countryRepo.findByIdOrNull(id)
            ?.toDto()
            ?: throw RuntimeException("Country not found!")
    }

    //поиск по части имени с помощью встроенного метода репозитория, http://.../search?prefix=Me
    override fun search(prefix: String): List<CountryDTO> =
        countryRepo.findByNameStartsWithIgnoreCaseOrderByName(prefix)
            .map { it.toDto() }


    //функция расширения позволяет вынести логику мапинга полей из основного метода сервиса
    private fun CountryEntity.toDto(): CountryDTO =
        CountryDTO(
            id = this.id,
            name = this.name,
            population = this.population
        )
}