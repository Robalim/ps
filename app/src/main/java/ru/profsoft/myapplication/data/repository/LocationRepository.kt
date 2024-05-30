package ru.profsoft.myapplication.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.profsoft.myapplication.data.api.ILocationManager
import ru.profsoft.myapplication.data.database.dao.LocationDao
import ru.profsoft.myapplication.data.mapToLocations
import ru.profsoft.myapplication.domain.model.Location
import ru.profsoft.myapplication.domain.repositories.ILocationRepository
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val locationManager: ILocationManager,
    private val locationDao: LocationDao
) : ILocationRepository {

    override suspend fun fetchLocations() {
        locationManager.startLocationUpdates()
    }

    override fun listenLocations(): Flow<List<Location>> {
        return locationDao.listenLocations().map { locations ->
            locations.mapToLocations()
        }
    }
}