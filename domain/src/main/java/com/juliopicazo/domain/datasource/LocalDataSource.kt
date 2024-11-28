package com.juliopicazo.domain.datasource

import com.juliopicazo.domain.model.New

interface LocalDataSource {
    fun getLocalNews(): List<New>
    suspend fun saveNews(news: List<New>)
    suspend fun deleteNew(newId: Int)
}