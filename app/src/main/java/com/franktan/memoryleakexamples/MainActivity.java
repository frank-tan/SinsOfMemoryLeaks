package com.franktan.memoryleakexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.franktan.memoryleakexamples.vialongrunningtask.LeakActivityToAsyncTaskActivity;
import com.franktan.memoryleakexamples.vialongrunningtask.LeakActivityToHandlerActivity;
import com.franktan.memoryleakexamples.vialongrunningtask.LeakActivityToThreadActivity;
import com.franktan.memoryleakexamples.vialongrunningtask.LeakThreadsActivity;
import com.franktan.memoryleakexamples.viastaticreference.LeakActivityToStaticInnerClassActivity;
import com.franktan.memoryleakexamples.viastaticreference.LeakActivityToSingletonActivity;
import com.franktan.memoryleakexamples.viastaticreference.LeakActivityToStaticVariableActivity;
import com.franktan.memoryleakexamples.viastaticreference.LeakActivityToStaticViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setLogo(R.drawable.ic_devil1);
            actionBar.setDisplayUseLogoEnabled(true);
        }

        Button buttonLeakActivityContextOrNot = (Button) findViewById(R.id.buttonLeakActivityContextOrNot);
        buttonLeakActivityContextOrNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeakActivityOrNot.class);
                startActivity(intent);
            }
        });

        Button buttonLeakActivityStaticView = (Button) findViewById(R.id.buttonLeakActivityStaticView);
        buttonLeakActivityStaticView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeakActivityToStaticViewActivity.class);
                startActivity(intent);
            }
        });

        Button buttonLeakActivityStaticVariable = (Button) findViewById(R.id.buttonLeakActivityStaticVariable);
        buttonLeakActivityStaticVariable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeakActivityToStaticVariableActivity.class);
                startActivity(intent);
            }
        });

        Button buttonLeakActivityContext = (Button) findViewById(R.id.buttonLeakActivityToSingleton);
        buttonLeakActivityContext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeakActivityToSingletonActivity.class);
                startActivity(intent);
            }
        });

        Button buttonLeakActivityToStaticVariableToInnerClass = (Button) findViewById(R.id.buttonLeakActivityToStaticVariableToInnerClass);
        buttonLeakActivityToStaticVariableToInnerClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeakActivityToStaticInnerClassActivity.class);
                startActivity(intent);
            }
        });

        Button buttonLeakActivityToInnerClassRunnable = (Button) findViewById(R.id.buttonLeakActivityToThread);
        buttonLeakActivityToInnerClassRunnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeakActivityToThreadActivity.class);
                startActivity(intent);
            }
        });

        Button buttonLeakActivityToHandler = (Button) findViewById(R.id.buttonLeakActivityToHandler);
        buttonLeakActivityToHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeakActivityToHandlerActivity.class);
                startActivity(intent);
            }
        });

        Button buttonLeakActivityToAsyncTask = (Button) findViewById(R.id.buttonLeakActivityToAsyncTask);
        buttonLeakActivityToAsyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeakActivityToAsyncTaskActivity.class);
                startActivity(intent);
            }
        });

        Button buttonLeakThread = (Button) findViewById(R.id.buttonLeakThread);
        buttonLeakThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeakThreadsActivity.class);
                startActivity(intent);
            }
        });
    }
}
