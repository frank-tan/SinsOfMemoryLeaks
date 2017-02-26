package com.franktan.memoryleakexamples.vialongrunningtask;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import com.franktan.memoryleakexamples.R;

public class LeakActivityToThreadActivity extends AppCompatActivity {

    private MyThread myThread = new MyThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_to_runnable);

        myThread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // FIXED: kill the thread in activity onDestroy
        myThread.interrupt();
    }

    // FIXED: make it static. So it does not have referenced to the containing activity class
    private static class MyThread extends Thread {
        @Override
        public void run() {
            // FIXED: check interrupted before the next loop
            while (!isInterrupted()) {
                SystemClock.sleep(1000);
            }
        }
    }
}
