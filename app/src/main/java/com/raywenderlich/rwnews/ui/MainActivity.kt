package com.raywenderlich.rwnews.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.raywenderlich.news.android.ui.list.NewsListFragment
import com.raywenderlich.rwnews.R

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
        .replace(R.id.anchor, NewsListFragment())
        .commit();
    }
  }
}
