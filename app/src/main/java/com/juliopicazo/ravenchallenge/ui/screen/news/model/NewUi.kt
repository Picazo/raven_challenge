package com.juliopicazo.ravenchallenge.ui.screen.news.model

import java.io.Serializable

data class NewUi(
    val id: Int,
    val title: String,
    val comment: String,
    val author: String,
    val createdAt: String,
    val url: String,
) : Serializable
