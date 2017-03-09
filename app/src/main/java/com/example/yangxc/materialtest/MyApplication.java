package com.example.yangxc.materialtest;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/2/25.
 */

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
//        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
