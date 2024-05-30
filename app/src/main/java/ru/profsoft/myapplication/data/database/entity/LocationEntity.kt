package ru.profsoft.myapplication.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.profsoft.myapplication.data.database.entity.LocationEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class LocationEntity(
    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: Long,
    @ColumnInfo(name = LATITUDE)
    val latitude: Double,
    @ColumnInfo(name = LONGITUDE)
    val longitude: Double,
    @ColumnInfo(name = TIMESTAMP)
    val timeStamp: Long
) {
    companion object {
        const val TABLE_NAME = "location"
        private const val ID = "location_id"
        private const val LATITUDE = "latitude"
        private const val LONGITUDE = "longitude"
        private const val TIMESTAMP = "TIMESTAMP"
    }
}