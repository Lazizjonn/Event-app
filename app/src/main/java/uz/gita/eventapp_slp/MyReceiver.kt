package uz.gita.eventapp_slp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer

class MyReceiver : BroadcastReceiver() {
    private val mySharedPref = MySharedPref.getMySharedPref()
    private lateinit var mediaPlayer: MediaPlayer

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_SCREEN_ON -> {
                if (mySharedPref.ACTION_SCREEN_ON) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.screen_on)
                    mediaPlayer.start()
                }
            }
            Intent.ACTION_SCREEN_OFF -> {
                if (mySharedPref.ACTION_SCREEN_OFF) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.screen_off)
                    mediaPlayer.start()
                }
            }
            Intent.ACTION_POWER_CONNECTED -> {
                if (mySharedPref.ACTION_POWER_CONNECTED) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.power_connected)
                    mediaPlayer.start()
                }
            }
            Intent.ACTION_POWER_DISCONNECTED -> {
                if (mySharedPref.ACTION_POWER_DISCONNECTED) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.power_disconnected)
                    mediaPlayer.start()
                }
            }
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                if (mySharedPref.ACTION_AIRPLANE_MODE_CHANGED) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.airplane_mode_changed)
                    mediaPlayer.start()
                }
            }
            Intent.ACTION_BATTERY_LOW -> {
                if (mySharedPref.ACTION_BATTERY_LOW) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.battery_low)
                    mediaPlayer.start()
                }
            }
            Intent.ACTION_BATTERY_OKAY -> {
                if (mySharedPref.ACTION_BATTERY_OKAY) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.battery_ok)
                    mediaPlayer.start()
                }
            }
            Intent.ACTION_TIME_CHANGED -> {
                if (mySharedPref.ACTION_TIME_CHANGED) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.time_changed)
                    mediaPlayer.start()
                }
            }
            Intent.ACTION_TIMEZONE_CHANGED -> {
                if (mySharedPref.ACTION_TIMEZONE_CHANGED) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.time_zone_changed)
                    mediaPlayer.start()
                }
            }
            Intent.ACTION_SHUTDOWN -> {
                if (mySharedPref.ACTION_SHUTDOWN) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.shut_down)
                    mediaPlayer.start()
                }
            }
        }
    }
}