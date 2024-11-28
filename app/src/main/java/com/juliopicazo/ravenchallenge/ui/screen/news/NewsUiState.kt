package com.juliopicazo.ravenchallenge.ui.screen.news

import com.juliopicazo.ravenchallenge.ui.screen.news.model.NewUi


data class NewsUiState(
    val loading: Boolean = false,
    val news: List<NewUi> = emptyList(),
    val refreshing: Boolean = false,
    val error: String? = ""
)
