package com.franktan.memoryleakexamples.vialongrunningtask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.franktan.memoryleakexamples.R;

public class LeakActivityToHandlerActivity extends AppCompatActivity {

    private final Handler mLeakyHandler = new MyHandler();
    private final MyRunnable myRunnable = new MyRunnable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_to_handler);

        // Post a message and delay its execution for 10 minutes.
        mLeakyHandler.postDelayed(myRunnable, 1000 * 60 * 10);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // FIXED: remove callback in activity onDestroy
        mLeakyHandler.removeCallbacks(myRunnable);
    }

    // FIXED: use static class instead of inner class. static class does not have reference to the containing activity
    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            Log.e("FRANK", "in run()");
        }
    }

    // FIXED: use static class instead of inner class. static class does not have reference to the containing activity
    private static class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Log.e("FRANK", "handle message");
        }
    }
}
