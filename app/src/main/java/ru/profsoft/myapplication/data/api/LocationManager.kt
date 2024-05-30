package ru.profsoft.myapplication.data.api

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import javax.inject.Inject

class LocationManager @Inject constructor(private val context: Context): ILocationManager {

    override fun startLocationUpdates() {
        (context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler).schedule(
            JobInfo.Builder(JOB_ID, ComponentName(context, LocationJobSchedulerService::class.java))
                .setPeriodic(TIMEOUT_LOCATION).build()
        )
    }

    companion object {
        private const val TIMEOUT_LOCATION : Long = 30 * 1000
        private const val JOB_ID = 1
    }
}