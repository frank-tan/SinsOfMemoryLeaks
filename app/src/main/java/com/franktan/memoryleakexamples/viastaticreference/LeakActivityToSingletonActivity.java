package com.franktan.memoryleakexamples.viastaticreference;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.franktan.memoryleakexamples.R;

/**
 * Created by frank.tan on 2/11/17.
 */

public class LeakActivityToSingletonActivity extends AppCompatActivity {

    SomeSingletonManager someSingletonManager = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_context_to_singleton);
        // FIXME: fix option 1: instead of passing `this` to getInstance(), pass getApplicationContext()
        someSingletonManager = SomeSingletonManager.getInstance(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("FRANK", "onDestroy: called");
        // FIXME: fix option 2: uncomment the following line to fix the leak
        //someSingletonManager.unregister(this);
    }
}
