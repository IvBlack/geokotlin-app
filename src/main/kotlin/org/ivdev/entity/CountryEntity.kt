package org.ivdev.entity

import jakarta.persistence.*
/*
Сущность д.б. именно class, не dataclass
Автоинкремент Id поля - на стороне БД.
* */
@Entity
@Table(name = "country")
class CountryEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String = "",
    val population: Int = 0

)