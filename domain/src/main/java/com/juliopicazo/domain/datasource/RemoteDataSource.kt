package com.juliopicazo.domain.datasource

import com.juliopicazo.domain.model.New

interface RemoteDataSource {
    suspend fun getNews(): List<New>
}