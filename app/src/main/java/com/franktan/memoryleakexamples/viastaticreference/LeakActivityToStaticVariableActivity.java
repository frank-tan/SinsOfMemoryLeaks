package com.franktan.memoryleakexamples.viastaticreference;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.franktan.memoryleakexamples.R;

public class LeakActivityToStaticVariableActivity extends AppCompatActivity {
    // FIXME: 2/26/17 static reference to the activity will leak the activity.
    // To fix it, set it null onDestroy or use weak reference
    static Activity activity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_context_to_static_variable);
        TextView textView = (TextView) findViewById(R.id.textView);

        if (activity == null) {
            activity = this;
        }
    }
}
