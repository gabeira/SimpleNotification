package com.sample.simplenotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void createNotification(View view) {

        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {

            // Prepare intent which is triggered if the
            // notification is selected
            Intent intent = new Intent(this, NotificationReceiverActivity.class);
            PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

            // Build notification
            // Actions are just fake
            Notification noti = new Notification.Builder(this)
                    .setContentTitle("New mail from " + "test@gmail.com")
                    .setContentText("Subject").setSmallIcon(R.drawable.ic_launcher)
                    .setContentIntent(pIntent)
                    .addAction(R.drawable.ic_launcher, "Call", pIntent)
                    .addAction(R.drawable.ic_launcher, "More", pIntent)
                    .addAction(R.drawable.ic_launcher, "And more", pIntent).build();
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // hide the notification after its selected
            noti.flags |= Notification.FLAG_AUTO_CANCEL;

            notificationManager.notify(0, noti);

        } else {

            // Prepare intent which is triggered if the
            // notification is selected
            Intent intent = new Intent(this, NotificationReceiverActivity.class);
            PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

            // Build notification
            // Actions are just fake
            Notification noti = new Notification.Builder(this)
//                    .setVisibility(Notification.VISIBILITY_PUBLIC)
                    .setVisibility(Notification.VISIBILITY_PRIVATE)
//                    .setVisibility(Notification.VISIBILITY_SECRET)

//                    .setCategory(Notification.CATEGORY_CALL) //Incoming call (voice or video) or similar synchronous communication request
                    .setCategory(Notification.CATEGORY_MESSAGE)//Incoming direct message (SMS, instant message, etc.)
//                    .setCategory(Notification.CATEGORY_EMAIL)//Asynchronous bulk message (email)
//                    .setCategory(Notification.CATEGORY_EVENT)//Calendar event
//                    .setCategory(Notification.CATEGORY_PROMO)//Promotion or advertisement
//                    .setCategory(Notification.CATEGORY_ALARM)//Alarm or timer
//                    .setCategory(Notification.CATEGORY_PROGRESS)//Progress of a long-running background operation
//                    .setCategory(Notification.CATEGORY_SOCIAL)//Social network or sharing update
//                    .setCategory(Notification.CATEGORY_ERROR)//Error in background operation or authentication status
//                    .setCategory(Notification.CATEGORY_TRANSPORT)//Media transport control for playback
//                    .setCategory(Notification.CATEGORY_SYSTEM)//System or device status update. Reserved for system use.
//                    .setCategory(Notification.CATEGORY_SERVICE)//Indication of running background service
//                    .setCategory(Notification.CATEGORY_RECOMMENDATION)//A specific, timely recommendation for a single thing. For example, a news app might want to recommend a news story it believes the user will want to read next.
//                    .setCategory(Notification.CATEGORY_STATUS)//Ongoing information about device or contextual status

                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher))

//                    .setPriority(Notification.PRIORITY_MAX)
                    .setPriority(Notification.PRIORITY_HIGH)
//                    .setPriority(Notification.PRIORITY_DEFAULT)
//                    .setPriority(Notification.PRIORITY_LOW)
//                    .setPriority(Notification.PRIORITY_MIN)

                    .setContentTitle("New mail from " + "test@gmail.com")
                    .setContentText("Subject").setSmallIcon(R.drawable.ic_launcher)
                    .setContentIntent(pIntent)
                    .addAction(R.drawable.ic_launcher, "Call", pIntent)
                    .addAction(R.drawable.ic_launcher, "More", pIntent)
                    .addAction(R.drawable.ic_launcher, "And more", pIntent)
                    .build();

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // hide the notification after its selected
            noti.flags |= Notification.FLAG_AUTO_CANCEL;

            notificationManager.notify(0, noti);

        }

    }
}
