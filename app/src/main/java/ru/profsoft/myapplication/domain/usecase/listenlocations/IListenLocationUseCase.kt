package ru.profsoft.myapplication.domain.usecase.listenlocations

import kotlinx.coroutines.flow.Flow
import ru.profsoft.myapplication.domain.model.Location

interface IListenLocationUseCase {

    operator fun invoke(): Flow<List<Location>>
}