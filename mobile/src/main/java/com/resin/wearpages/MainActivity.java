package com.resin.wearpages;

import android.app.Notification;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendNotify();
    }

    void sendNotify() {
        Context context = MainActivity.this;
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        
        for (int i = 0; i < 10; i++) {
            Notification page = new NotificationCompat.Builder(context)
                    .setContentTitle("Title" + i)
                    .setContentText("Text" + i)
                    .build();

            Notification card = new Notification.Builder(context)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Title" + i)
                    .setContentText("Text" + i)
                    .setSortKey("" + i)
                    .extend(new Notification.WearableExtender()
                            .addPage(exPage(i + ", " + 1))
                            .addPage(exPage(i + ", " + 2))
                            .addPage(exPage(i + ", " + 3))
                            .addPage(exPage(i + ", " + 4))
                            .addPage(exPage(i + ", " + 5)))
                    .build();

            notificationManager.notify(i, card);
        }
    }

    Notification exPage(String title) {
        Context context = MainActivity.this;
        return new NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setContentText("Text")
                .build();
    }
}
