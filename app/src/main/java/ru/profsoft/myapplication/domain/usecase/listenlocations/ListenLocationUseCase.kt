package ru.profsoft.myapplication.domain.usecase.listenlocations

import kotlinx.coroutines.flow.Flow
import ru.profsoft.myapplication.domain.model.Location
import ru.profsoft.myapplication.domain.repositories.ILocationRepository
import javax.inject.Inject

class ListenLocationUseCase @Inject constructor(private val locationRepository: ILocationRepository) : IListenLocationUseCase {
    override fun invoke(): Flow<List<Location>> {
        return locationRepository.listenLocations()
    }

}