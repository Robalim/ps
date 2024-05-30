package ru.profsoft.myapplication.domain.repositories

import kotlinx.coroutines.flow.Flow
import ru.profsoft.myapplication.domain.model.Location

interface ILocationRepository {

    suspend fun fetchLocations()

    fun listenLocations(): Flow<List<Location>>
}