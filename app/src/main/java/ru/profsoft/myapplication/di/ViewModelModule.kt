package ru.profsoft.myapplication.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import ru.profsoft.myapplication.data.api.ILocationManager
import ru.profsoft.myapplication.data.api.LocationManager
import ru.profsoft.myapplication.data.repository.LocationRepository
import ru.profsoft.myapplication.domain.repositories.ILocationRepository
import ru.profsoft.myapplication.domain.usecase.fetchlocations.FetchLocationUseCase
import ru.profsoft.myapplication.domain.usecase.fetchlocations.IFetchLocationUseCase
import ru.profsoft.myapplication.domain.usecase.listenlocations.IListenLocationUseCase
import ru.profsoft.myapplication.domain.usecase.listenlocations.ListenLocationUseCase

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {

    @Binds
    @ViewModelScoped
    abstract fun provideLocationManager(locationManager: LocationManager): ILocationManager

    @Binds
    @ViewModelScoped
    abstract fun provideRepository(repository: LocationRepository): ILocationRepository

    @Binds
    @ViewModelScoped
    abstract fun provideFetchLocationUseCase(useCase: FetchLocationUseCase): IFetchLocationUseCase

    @Binds
    @ViewModelScoped
    abstract fun provideListenLocationUseCase(useCase: ListenLocationUseCase): IListenLocationUseCase
}