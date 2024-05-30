package ru.profsoft.myapplication.data.api

import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Context
import android.util.Log
import com.google.android.gms.location.CurrentLocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationTokenSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.profsoft.myapplication.data.database.dao.LocationDao
import ru.profsoft.myapplication.data.mapToLocationEntity
import javax.inject.Inject

class LocationJobSchedulerService @Inject constructor(
    private val context: Context,
    private val locationDao: LocationDao
) : JobService() {

    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val locationProvider by lazy { LocationServices.getFusedLocationProviderClient(context) }
    override fun onStartJob(params: JobParameters?): Boolean {
        try {
            locationProvider.getCurrentLocation(
                CurrentLocationRequest.Builder().build(),
                CancellationTokenSource().token
            ).addOnSuccessListener {
                scope.launch {
                    locationDao.saveLocation(it.mapToLocationEntity())
                }
            }
        } catch (e: SecurityException) {
            Log.d("Some tag", e.message ?: "")
        }
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        return true
    }
}