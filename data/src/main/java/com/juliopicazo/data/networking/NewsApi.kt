package com.juliopicazo.data.networking

import com.juliopicazo.data.networking.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("search_by_date")
    suspend fun getNews(
        @Query("query") query: String,
    ): Response<NewsResponse>

}