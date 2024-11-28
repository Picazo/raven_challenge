package com.juliopicazo.domain.interactor

import com.juliopicazo.domain.repository.NewsRepository
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNewsUseCaseImpl @Inject constructor(
    private val newsRepository: NewsRepository,
) : GetNewsUseCase {
    override suspend operator fun invoke() =
        flow {
            emitAll(newsRepository.getNews())
        }
}