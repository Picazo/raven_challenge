package com.juliopicazo.domain.interactor

import com.juliopicazo.domain.model.New
import com.juliopicazo.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface GetNewsUseCase {
    suspend operator fun invoke(): Flow<Resource<List<New>>>
}