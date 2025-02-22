package com.example.raazassigment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RaazApplication: Application() {
    companion object{
        @JvmStatic
        var instance :RaazApplication?= null
    }

    override fun onCreate() {
        super.onCreate()
        instance=this
    }

}