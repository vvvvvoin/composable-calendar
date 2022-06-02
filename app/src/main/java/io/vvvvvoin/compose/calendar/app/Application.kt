package io.vvvvvoin.compose.calendar.app

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class Application : Application() {
    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)
    }
}