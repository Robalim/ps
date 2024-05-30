package ru.profsoft.myapplication.domain.usecase.fetchlocations

import ru.profsoft.myapplication.domain.repositories.ILocationRepository
import javax.inject.Inject

class FetchLocationUseCase @Inject constructor(private val repository: ILocationRepository): IFetchLocationUseCase {
    override suspend fun invoke() {
        return repository.fetchLocations()
    }
}