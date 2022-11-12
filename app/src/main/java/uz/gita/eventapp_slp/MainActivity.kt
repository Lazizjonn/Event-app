package uz.gita.eventapp_slp

import android.content.Intent
import android.content.Intent.*
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.eventapp_slp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val mySharedPref = MySharedPref.getMySharedPref()
    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        isCheckedSet()
        setOnClicks()
    }
    override fun onResume() {
        super.onResume()
        startMyService()
    }

    private fun setOnClicks() = binding.scope {
        mySharedPref.scope {
            screenOnSwitch.setOnClickListener { ACTION_SCREEN_ON = screenOnSwitch.isChecked }
            screenOffSwitch.setOnClickListener { ACTION_SCREEN_OFF = screenOffSwitch.isChecked }
            powerConnectedSwitch.setOnClickListener { ACTION_POWER_CONNECTED = powerConnectedSwitch.isChecked }
            powerDisconnectedSwitch.setOnClickListener { ACTION_POWER_DISCONNECTED = powerDisconnectedSwitch.isChecked }
            airplaneModeChangedSwitch.setOnClickListener { ACTION_AIRPLANE_MODE_CHANGED = airplaneModeChangedSwitch.isChecked }
            batteryLowSwitch.setOnClickListener { ACTION_BATTERY_LOW = batteryLowSwitch.isChecked }
            batteryOkSwitch.setOnClickListener { ACTION_BATTERY_OKAY = batteryOkSwitch.isChecked }
            timeChangedSwitch.setOnClickListener { ACTION_TIME_CHANGED = timeChangedSwitch.isChecked }
            timeZoneSwitch.setOnClickListener { ACTION_TIMEZONE_CHANGED = timeZoneSwitch.isChecked }
            shutDownSwitch.setOnClickListener { ACTION_SHUTDOWN = shutDownSwitch.isChecked }
        }

    }
    private fun isCheckedSet() = binding.scope {
        mySharedPref.scope {
            screenOnSwitch.isChecked = ACTION_SCREEN_ON
            screenOffSwitch.isChecked = ACTION_SCREEN_OFF
            powerConnectedSwitch.isChecked = ACTION_POWER_CONNECTED
            powerDisconnectedSwitch.isChecked = ACTION_POWER_DISCONNECTED
            airplaneModeChangedSwitch.isChecked = ACTION_AIRPLANE_MODE_CHANGED
            batteryLowSwitch.isChecked = ACTION_BATTERY_LOW
            batteryOkSwitch.isChecked = ACTION_BATTERY_OKAY
            timeChangedSwitch.isChecked = ACTION_TIME_CHANGED
            timeZoneSwitch.isChecked = ACTION_TIMEZONE_CHANGED
            shutDownSwitch.isChecked = ACTION_SHUTDOWN
        }
    }
    private fun startMyService() {
        val intent = Intent(this@MainActivity, MyService::class.java)
        intent.putExtra("STOP", "START")
        if (Build.VERSION.SDK_INT >= 26) this@MainActivity.startForegroundService(intent)
        else this@MainActivity.startService(intent)
    }
}