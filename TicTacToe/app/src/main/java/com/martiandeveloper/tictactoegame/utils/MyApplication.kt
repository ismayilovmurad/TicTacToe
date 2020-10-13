@file:Suppress("unused")

package com.martiandeveloper.tictactoegame.utils

import android.app.Application
import timber.log.Timber

const val IN_APP_UPDATE_REQUEST_CODE = 100

const val FIRST_SHARED_PREFERENCES = "First"
const val FIRST_KEY = "first"

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}
