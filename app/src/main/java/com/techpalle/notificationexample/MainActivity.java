package com.techpalle.notificationexample;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        FragmentOne fragmentOne = new FragmentOne();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentOne);
        transaction.commit();
    }
}
