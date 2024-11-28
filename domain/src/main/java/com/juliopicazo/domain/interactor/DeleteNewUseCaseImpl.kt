package com.juliopicazo.domain.interactor

import com.juliopicazo.domain.model.New
import com.juliopicazo.domain.repository.NewsRepository
import com.juliopicazo.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeleteNewUseCaseImpl @Inject constructor(
    private val newsRepository: NewsRepository,
) : DeleteNewUseCase {

    override suspend fun invoke(newId: Int): Flow<Resource<List<New>>> = flow {
        emitAll(newsRepository.deleteNew(newId))
    }
}