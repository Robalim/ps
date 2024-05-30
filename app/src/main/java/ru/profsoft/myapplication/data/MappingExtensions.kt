package ru.profsoft.myapplication.data

import ru.profsoft.myapplication.data.database.entity.LocationEntity
import ru.profsoft.myapplication.domain.model.Location

fun List<LocationEntity>.mapToLocations(): List<Location> {
    return map {
        Location(
            id = it.id,
            latitude = it.latitude,
            longitude = it.longitude,
            timeStamp = it.timeStamp
        )
    }
}

fun android.location.Location.mapToLocationEntity(): LocationEntity {
    return LocationEntity(
        id = time,
        latitude = latitude,
        longitude = longitude,
        timeStamp = time
    )
}