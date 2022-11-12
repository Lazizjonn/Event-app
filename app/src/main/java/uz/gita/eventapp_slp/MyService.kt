package uz.gita.eventapp_slp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.IBinder
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat

class MyService : Service() {
    private val myReceiver = MyReceiver()
    private val CHANNEL = "EVENT"

    override fun onBind(intent: Intent?): IBinder? = null
    override fun onCreate() {
        super.onCreate()
        createChannel()
        createForegroundService()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.extras?.get("STOP") != "STOP") {
            val filter = IntentFilter().apply {
                addAction(Intent.ACTION_SCREEN_ON)
                addAction(Intent.ACTION_SCREEN_OFF)
                addAction(Intent.ACTION_POWER_CONNECTED)
                addAction(Intent.ACTION_POWER_DISCONNECTED)
                addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
                addAction(Intent.ACTION_BATTERY_LOW)
                addAction(Intent.ACTION_BATTERY_OKAY)
                addAction(Intent.ACTION_TIME_CHANGED)
                addAction(Intent.ACTION_TIMEZONE_CHANGED)
                addAction(Intent.ACTION_SHUTDOWN)
            }

            registerReceiver(myReceiver, filter)
            createForegroundService()
            return START_NOT_STICKY
        } else {
            stopSelf()
            return START_NOT_STICKY
        }
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            val channel = NotificationChannel("EVENT", CHANNEL, NotificationManager.IMPORTANCE_DEFAULT)
            channel.setSound(null, null)
            val service = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            service.createNotificationChannel(channel)
        }
    }
    private fun createForegroundService() {
        val notifyIntent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val notifyPendingIntent = PendingIntent.getActivity(
            this,
            0,
            notifyIntent,
            PendingIntent.FLAG_MUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val notification = NotificationCompat.Builder(this, CHANNEL)
            .setContentTitle("Event detector is working")
            .setSmallIcon(R.drawable.icon)
            .setContentIntent(notifyPendingIntent)
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setCustomBigContentView(createRemoteView())
            .build()

        startForeground(1, notification)
    }
    private fun createRemoteView(): RemoteViews {
        val view = RemoteViews(this.packageName, R.layout.remote_view)
        view.setOnClickPendingIntent(R.id.remoteButtonClose, createPendingIntent())
        return view
    }
    private fun createPendingIntent(): PendingIntent {
        val intent = Intent(this, MyService::class.java)
        intent.putExtra("STOP", "STOP")
        return PendingIntent.getService(
            this,
            1,
            intent,
            PendingIntent.FLAG_MUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
    }
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myReceiver)
    }

}