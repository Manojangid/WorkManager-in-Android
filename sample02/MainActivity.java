package com.manoj.workmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import java.util.concurrent.TimeUnit;

/**
 * WorkManager with Periodic task
 * */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final PeriodicWorkRequest request = new PeriodicWorkRequest.Builder(MyWorker.class, 15,TimeUnit.MINUTES)
                .build();

        findViewById(R.id.startBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkManager.getInstance(MainActivity.this).enqueue(request);
            }
        });
        final TextView textView = findViewById(R.id.textView);
        WorkManager.getInstance(MainActivity.this).getWorkInfoByIdLiveData(request.getId()).observe(MainActivity.this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                String info = workInfo.getState().name();
                textView.setText(info + "\n");
            }
        });
    }
}
