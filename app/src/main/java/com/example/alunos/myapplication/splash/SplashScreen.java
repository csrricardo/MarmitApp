package com.example.alunos.myapplication.splash;

import android.app.Application;
import android.os.SystemClock;

public class SplashScreen extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SystemClock.sleep(java.util.concurrent.TimeUnit.SECONDS.toMillis(3));
    }
}
