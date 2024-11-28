package com.juliopicazo.data.mapper

import com.juliopicazo.data.networking.model.Hit
import com.juliopicazo.domain.model.New

fun Hit.toDomain(): New {
    return New(
        id = objectId.toIntOrNull() ?: 0,
        title = storyTitle ?: title ?: "",
        comment = commentText ?: "Sin comentario",
        author = author,
        createdAt = createdAt,
        url = storyUrl ?: ""
    )
}

fun List<Hit>.toDomain(): List<New> {
    return this.map { it.toDomain() }
}