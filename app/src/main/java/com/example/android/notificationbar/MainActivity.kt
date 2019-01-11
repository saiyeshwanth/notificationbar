package com.example.android.notificationbar

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var count = 0
        button.setOnClickListener {
            val nManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val nBuilder: NotificationCompat.Builder = NotificationCompat.Builder(this,"sai")
            nBuilder.setSmallIcon(R.drawable.ic_today_black_24dp)
            nBuilder.setTicker("BasicNotifications")
            val bmp = BitmapFactory.decodeResource(resources, R.drawable.ic_warning_black_24dp)
            nBuilder.setLargeIcon(bmp)
            nBuilder.setContentTitle("Notification Title")
            nBuilder.setContentText("Thank you for creating a notification,see you again,BYE!")
            nBuilder.setStyle(NotificationCompat.BigTextStyle().bigText("Thank you for creating a notification,see you again,BYE!"))
            nBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT)
            nBuilder.setAutoCancel(true)
            val i = Intent(this@MainActivity, MainActivity::class.java)
            val pIntent = PendingIntent.getActivity(this@MainActivity, 0, i, 0)
            nBuilder.setContentIntent(pIntent)
            nManager.notify(++count, nBuilder.build())



        }
    }
}
