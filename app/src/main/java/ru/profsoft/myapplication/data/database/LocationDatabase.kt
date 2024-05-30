package ru.profsoft.myapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.profsoft.myapplication.data.database.dao.LocationDao
import ru.profsoft.myapplication.data.database.entity.LocationEntity

@Database(entities = [LocationEntity::class], version = 1, exportSchema = false)
abstract class LocationDatabase: RoomDatabase() {

    abstract fun locationDao(): LocationDao

}