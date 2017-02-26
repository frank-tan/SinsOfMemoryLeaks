package com.franktan.memoryleakexamples.vialongrunningtask;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import com.franktan.memoryleakexamples.R;

public class LeakThreadsActivity extends AppCompatActivity {
    private LeakedThread mThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_thread);

        mThread = new LeakedThread();
        mThread.start();
    }

    private static class LeakedThread extends Thread {

        @Override
        public void run() {
            while (!isInterrupted()) {
                SystemClock.sleep(1000);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // FIXME: 2/26/17 uncomment the line to fix the thread leak
        mThread.interrupt();
    }
}
