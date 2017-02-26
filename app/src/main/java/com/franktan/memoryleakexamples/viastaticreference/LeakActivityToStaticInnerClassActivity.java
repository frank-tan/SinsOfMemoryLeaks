package com.franktan.memoryleakexamples.viastaticreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.franktan.memoryleakexamples.R;

public class LeakActivityToStaticInnerClassActivity extends AppCompatActivity {
    // FIXED: remove static keywords
    private SomeInnerClass someInnerClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_static_reference_to_inner_class);

        someInnerClass = new SomeInnerClass();
    }

    class SomeInnerClass {
    }
}
