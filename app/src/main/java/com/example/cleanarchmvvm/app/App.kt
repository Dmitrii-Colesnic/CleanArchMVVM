package com.example.cleanarchmvvm.app

import android.app.Application
import com.example.cleanarchmvvm.di.AppComponent
import com.example.cleanarchmvvm.di.AppModule
import com.example.cleanarchmvvm.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}