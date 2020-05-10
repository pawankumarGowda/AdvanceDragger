package com.raywenderlich.rwnews.init

import android.app.Application
import com.raywenderlich.rwnews.di.AppComponent
import com.raywenderlich.rwnews.di.DaggerAppComponent
import com.raywenderlich.rwnews.repository.impl.MemoryNewsRepository

class InitApp : Application() {
  
  lateinit var appComponent: AppComponent

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerAppComponent
      .factory()
      .repository(MemoryNewsRepository())
  }

  fun appComp() = appComponent
}
