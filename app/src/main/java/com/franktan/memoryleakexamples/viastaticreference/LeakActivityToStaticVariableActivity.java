package com.franktan.memoryleakexamples.viastaticreference;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.franktan.memoryleakexamples.R;

public class LeakActivityToStaticVariableActivity extends AppCompatActivity {
    // FIXED: remove static keyword. If it has to be static for whatever valid reason, use WeakReference
    private Activity activity = null;

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
