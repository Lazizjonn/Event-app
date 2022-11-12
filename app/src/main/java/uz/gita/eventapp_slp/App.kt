package uz.gita.eventapp_slp

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MySharedPref.init(this)
    }
}