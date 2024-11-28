package com.juliopicazo.data.repository

import com.juliopicazo.data.database.dao.NewDao
import com.juliopicazo.data.database.mapper.toDomain
import com.juliopicazo.data.database.mapper.toEntity
import com.juliopicazo.domain.datasource.LocalDataSource
import com.juliopicazo.domain.model.New
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val newDao: NewDao
) : LocalDataSource {

    override fun getLocalNews(): List<New> =
        newDao.getNews().map { entities -> entities.toDomain() }

    override suspend fun saveNews(news: List<New>) {
        val deletedIds = newDao.getDeletedNewsIds()

        val entities = news.map { new ->
            new.toEntity().copy(
                isActive = !deletedIds.contains(new.id)
            )
        }

        newDao.insertNews(entities)
    }

    override suspend fun deleteNew(newId: Int) {
        newDao.deleteNew(newId)
    }

}
