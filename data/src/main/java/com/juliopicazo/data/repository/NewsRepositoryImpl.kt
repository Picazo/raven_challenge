package com.juliopicazo.data.repository

import com.juliopicazo.data.utils.NetworkHelper
import com.juliopicazo.domain.datasource.LocalDataSource
import com.juliopicazo.domain.datasource.RemoteDataSource
import com.juliopicazo.domain.model.New
import com.juliopicazo.domain.repository.NewsRepository
import com.juliopicazo.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val networkHelper: NetworkHelper,
) : NewsRepository {

    override suspend fun getNews(): Flow<Resource<List<New>>> = flow {
        emit(Resource.loading())
        try {
            if (networkHelper.isNetworkConnected()) {
                val remoteNews = remoteDataSource.getNews()

                localDataSource.saveNews(remoteNews)
                emit(Resource.success(localDataSource.getLocalNews()))
            } else {
                val localNews = localDataSource.getLocalNews()
                emit(Resource.success(localNews))
            }
        } catch (e: Exception) {
            try {
                val localNews = localDataSource.getLocalNews()
                emit(Resource.success(localNews))
            } catch (e: Exception) {
                emit(Resource.error(e.message ?: "Error desconocido"))
            }
        }
    }

    override suspend fun deleteNew(newId: Int): Flow<Resource<List<New>>> = flow {
        try {
            localDataSource.deleteNew(newId)
            val localNews = localDataSource.getLocalNews()
            emit(Resource.success(localNews))
        } catch (e: Exception) {
            emit(Resource.error(e.message ?: "Error desconocido"))
        }
    }

}