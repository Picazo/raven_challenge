package com.juliopicazo.data.repository

import com.juliopicazo.data.mapper.toDomain
import com.juliopicazo.data.networking.NewsApi
import com.juliopicazo.domain.datasource.RemoteDataSource
import com.juliopicazo.domain.model.New
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val newsApi: NewsApi
) : RemoteDataSource {

    override suspend fun getNews(): List<New> {
        val response = newsApi.getNews("android")
        return if (response.isSuccessful) {
            response.body()?.hits?.toDomain() ?: emptyList()
        } else {
            emptyList()
        }
    }
}
