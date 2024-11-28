package com.juliopicazo.data.database.mapper

import com.juliopicazo.data.database.entity.NewEntity
import com.juliopicazo.domain.model.New

fun NewEntity.toDomain() = New(
    id = id,
    title = title,
    comment = comment,
    author = author,
    createdAt = createdAt,
    url = url
)

fun New.toEntity() = NewEntity(
    id = id,
    title = title,
    comment = comment,
    author = author,
    createdAt = createdAt,
    url = url
)