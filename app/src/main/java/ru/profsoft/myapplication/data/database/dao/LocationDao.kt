package ru.profsoft.myapplication.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.profsoft.myapplication.data.database.entity.LocationEntity

@Dao
interface LocationDao {

    @Insert(entity = LocationEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocation(location: LocationEntity)

    @Query("Select * From ${LocationEntity.TABLE_NAME}")
    fun listenLocations(): Flow<List<LocationEntity>>
}