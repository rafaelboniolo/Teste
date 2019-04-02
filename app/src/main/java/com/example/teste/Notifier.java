package com.example.teste;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;

public class Notifier extends AccessibilityService {

    @Override
    public void onCreate(){
        Toast.makeText(this,"Oncreate", Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onServiceConnected() {
        Toast.makeText(this,"Service connected", Toast.LENGTH_LONG).show();
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_ALL_MASK;;
        info.eventTypes = AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED ;

        info.packageNames = new String[] {"com.whatsapp"};
        info.notificationTimeout = 100;

        setServiceInfo(info);

    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Toast.makeText(this,"Notification Catched", Toast.LENGTH_LONG).show();

        if(event.getEventType() == AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED) {

            Toast.makeText(this,"Notification Catched", Toast.LENGTH_LONG).show();
            Log.i("ANAGRAMMATICALLY", "onAccessibilityEvent: ");
        }

    }

    @Override
    public void onInterrupt() {
        Toast.makeText(this,"Service interruped", Toast.LENGTH_LONG).show();
    }
}