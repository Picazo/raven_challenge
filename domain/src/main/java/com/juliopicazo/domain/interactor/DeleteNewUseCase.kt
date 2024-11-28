package com.juliopicazo.domain.interactor

import com.juliopicazo.domain.model.New
import com.juliopicazo.domain.utils.Resource
import kotlinx.coroutines.flow.Flow


interface DeleteNewUseCase {
    suspend operator fun invoke(newId: Int) : Flow<Resource<List<New>>>
}