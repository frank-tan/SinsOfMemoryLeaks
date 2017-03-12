package com.franktan.memoryleakexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LeakActivityOrNot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Google says passing activity context to a dynamically created view causes a memory leak in
        // a 2009 post https://android-developers.googleblog.com/2009/01/avoiding-memory-leaks.html
        // Does it still cause a leak now?
        TextView label = new TextView(this);
        label.setText(getString(R.string.google_leak_not, getString(R.string.instruction_check_for_leaks)));

        setContentView(label);
    }
}
