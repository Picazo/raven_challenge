package com.juliopicazo.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val comment: String,
    val author: String,
    val createdAt: String,
    val isActive: Boolean = true,
    val url: String
)
