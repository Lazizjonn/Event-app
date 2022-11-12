package uz.gita.eventapp_slp

import android.content.Context
import android.content.SharedPreferences

class MySharedPref {
    companion object {
        private var preferences: SharedPreferences? = null
        private var mySharedPref: MySharedPref? = null

        fun init(context: Context) {
            mySharedPref = MySharedPref()
            preferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
        }

        fun getMySharedPref(): MySharedPref {
            return mySharedPref!!
        }
    }

    var ACTION_SCREEN_ON: Boolean
        get() = preferences!!.getBoolean("ACTION_SCREEN_ON", false)
        set(value) = preferences!!.edit().putBoolean("ACTION_SCREEN_ON", value).apply()

    var ACTION_SCREEN_OFF: Boolean
        get() = preferences!!.getBoolean("ACTION_SCREEN_OFF", false)
        set(value) = preferences!!.edit().putBoolean("ACTION_SCREEN_OFF", value).apply()

    var ACTION_POWER_CONNECTED: Boolean
        get() = preferences!!.getBoolean("ACTION_POWER_CONNECTED", false)
        set(value) = preferences!!.edit().putBoolean("ACTION_POWER_CONNECTED", value).apply()

    var ACTION_POWER_DISCONNECTED: Boolean
        get() = preferences!!.getBoolean("ACTION_POWER_DISCONNECTED", false)
        set(value) = preferences!!.edit().putBoolean("ACTION_POWER_DISCONNECTED", value).apply()

    var ACTION_AIRPLANE_MODE_CHANGED: Boolean
        get() = preferences!!.getBoolean("ACTION_AIRPLANE_MODE_CHANGED", false)
        set(value) = preferences!!.edit().putBoolean("ACTION_AIRPLANE_MODE_CHANGED", value).apply()

    var ACTION_BATTERY_LOW: Boolean
        get() = preferences!!.getBoolean("ACTION_BATTERY_LOW", false)
        set(value) = preferences!!.edit().putBoolean("ACTION_BATTERY_LOW", value).apply()

    var ACTION_BATTERY_OKAY: Boolean
        get() = preferences!!.getBoolean("ACTION_BATTERY_OKAY", false)
        set(value) = preferences!!.edit().putBoolean("ACTION_BATTERY_OKAY", value).apply()

    var ACTION_TIME_CHANGED: Boolean
        get() = preferences!!.getBoolean("ACTION_TIME_CHANGED", false)
        set(value) = preferences!!.edit().putBoolean("ACTION_TIME_CHANGED", value).apply()

    var ACTION_TIMEZONE_CHANGED: Boolean
        get() = preferences!!.getBoolean("ACTION_TIMEZONE_CHANGED", false)
        set(value) = preferences!!.edit().putBoolean("ACTION_TIMEZONE_CHANGED", value).apply()

    var ACTION_SHUTDOWN: Boolean
        get() = preferences!!.getBoolean("ACTION_SHUTDOWN", false)
        set(value) = preferences!!.edit().putBoolean("ACTION_SHUTDOWN", value).apply()
}