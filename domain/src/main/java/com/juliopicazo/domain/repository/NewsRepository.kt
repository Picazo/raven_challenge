package com.juliopicazo.domain.repository

import com.juliopicazo.domain.model.New
import com.juliopicazo.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNews(): Flow<Resource<List<New>>>
    suspend fun deleteNew(newId: Int): Flow<Resource<List<New>>>

}