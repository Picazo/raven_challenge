package com.juliopicazo.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.juliopicazo.data.database.entity.NewEntity

@Dao
interface NewDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(news: List<NewEntity>)

    @Transaction
    @Query("SELECT * FROM news WHERE isActive = 1")
    fun getNews(): List<NewEntity>

    @Query("UPDATE news SET isActive = 0 WHERE id = :newId")
    suspend fun deleteNew(newId: Int)

    @Query("SELECT id FROM news WHERE isActive = 0")
    suspend fun getDeletedNewsIds(): List<Int>

}