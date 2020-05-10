package com.raywenderlich.rwnews.presenter.impl

import android.util.Log
import com.raywenderlich.common.mvp.impl.BasePresenter
import com.raywenderlich.rwnews.conf.TAG
import com.raywenderlich.rwnews.model.NewsModel
import com.raywenderlich.rwnews.presenter.NewsDetailPresenter
import com.raywenderlich.rwnews.repository.NewsRepository
import com.raywenderlich.rwnews.ui.detail.NewsDetailView
import javax.inject.Inject


/**
 * Presenter for the display of the list
 */
class NewsDetailPresenterImpl @Inject constructor(
  private val newsRepository: NewsRepository
) : BasePresenter<NewsModel, NewsDetailView>(),
  NewsDetailPresenter {

  override fun displayNewsDetail(newsId: Long) {
    Log.i(TAG, "In NewsDetailPresenterImpl using Repository $newsRepository")
    newsRepository.byId(newsId)?.let { news ->
      view?.displayNews(news)
    }
  }
}