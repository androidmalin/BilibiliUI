package com.malin.bilibili.design;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by malin on 16-5-24.
 */
public class CheesesApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "900031626", false);//BugLy
    }
}
