package ru.profsoft.myapplication.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.profsoft.myapplication.data.api.LocationJobSchedulerService
import ru.profsoft.myapplication.data.database.LocationDatabase
import ru.profsoft.myapplication.data.database.dao.LocationDao

@Module
@InstallIn(SingletonComponent::class)
class SingletonModule {

    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    fun provideJobScheduler(context: Context, dao: LocationDao): LocationJobSchedulerService {
        return LocationJobSchedulerService(context, dao)
    }

    @Provides
    fun provideDao(database: LocationDatabase): LocationDao {
        return database.locationDao()
    }

    @Provides
    fun provideDatabase(context: Context): LocationDatabase {
        return Room.databaseBuilder(context, LocationDatabase::class.java, "locations").build()
    }
}