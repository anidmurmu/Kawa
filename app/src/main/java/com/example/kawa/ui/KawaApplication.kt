package com.example.kawa.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class KawaApplication : Application() {

    companion object {
        lateinit var instance: KawaApplication
        const val TAG = "GridApplication"
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}

