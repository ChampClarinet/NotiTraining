package com.example.clarinetmaster.notitraining;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TITLE = "Yo";
    private static final String MESSAGE = "This is Noti";

    PendingIntent pendingIntent;
    Notification notification;
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btn_notification);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIntentForNoti();
                buildNotification(v);
                showNotification(v);
            }
        });

    }

    public void setIntentForNoti(){
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/champclarinetmaster"));
        //pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Intent intent = new Intent(this, PushActivity.class);
        intent.putExtra("message", MESSAGE);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(PushActivity.class);
        stackBuilder.addNextIntent(intent);
        pendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    public void buildNotification(View view){
        Uri sound = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.arpeggio);
        notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("yo")
                .setContentText("This is noti")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setSound(sound)
                .build();
        //notification.defaults |= Notification.DEFAULT_SOUND;
    }

    public void showNotification(View view) {
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1000, notification);
    }

}