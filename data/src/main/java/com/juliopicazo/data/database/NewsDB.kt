package com.juliopicazo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.juliopicazo.data.database.dao.NewDao
import com.juliopicazo.data.database.entity.NewEntity

@Database(
    entities = [
        NewEntity::class,
    ],
    version = 1
)
abstract class NewsDB : RoomDatabase() {
    abstract fun newDao(): NewDao
}