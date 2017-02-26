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
        // Alternative fix is to pass in getApplicationContext() instead of `this`
        someSingletonManager = SomeSingletonManager.getInstance(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("FRANK", "onDestroy: called");
        // FIXED: unregister it onDestroy. Alternatively, see comment in line 22
        someSingletonManager.unregister(this);
    }
}
