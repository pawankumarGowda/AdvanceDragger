package com.raywenderlich.rwnews.di

import com.raywenderlich.rwnews.presenter.NewsDetailPresenter
import com.raywenderlich.rwnews.presenter.NewsListPresenter
import com.raywenderlich.rwnews.presenter.impl.NewsDetailPresenterImpl
import com.raywenderlich.rwnews.presenter.impl.NewsListPresenterImpl
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

  @Binds
  abstract fun provideNewsListPresenter(newsRepository: NewsListPresenterImpl): NewsListPresenter

  @Binds
  abstract fun provideNewsDetailPresenter(newsRepository: NewsDetailPresenterImpl): NewsDetailPresenter

}



