package com.raywenderlich.rwnews.presenter

import com.raywenderlich.common.mvp.Presenter
import com.raywenderlich.rwnews.model.NewsModel
import com.raywenderlich.rwnews.ui.detail.NewsDetailView

/**
 * The Presenter for the News Detail
 */
interface NewsDetailPresenter : Presenter<NewsModel, NewsDetailView> {

  /**
   * Invoke in order to display the detail for the news
   */
  fun displayNewsDetail(newsId: Long)
}