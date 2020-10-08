@file:Suppress("unused")

package com.martiandeveloper.tictactoe.utils

import android.app.Application
import timber.log.Timber

const val IN_APP_UPDATE_REQUEST_CODE = 100

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}
