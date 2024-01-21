package org.ivdev.repo

import org.ivdev.entity.CountryEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

/*
Первым параметром - тип-класс, что мапится на таблицу
Spring Data сделает всю работу по созданию нужных методов,
достаточно отснаследоваться от CrudRepository.

Data JPA поддерживает соглашение об именовании.
Если именовать методы по правилам spring data, реализация методов будет генерироваться автоматически.
findByOrderByNameDesc, например, отсортирует по убыванию имени.

Параметр pageable реализует пагинацию в связке с контроллером и сервисом.
При пагинации д.б. реализована сортировка.
*/
interface CountryRepo: CrudRepository<CountryEntity, Int> {
    fun findByOrderByName(pageable: Pageable): List<CountryEntity>

    fun findByNameStartsWithIgnoreCaseOrderByName(prefix: String): List<CountryEntity>
}