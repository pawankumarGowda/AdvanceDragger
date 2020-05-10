package com.raywenderlich.rwnews.presenter

import com.raywenderlich.common.mvp.Presenter
import com.raywenderlich.rwnews.model.NewsListModel
import com.raywenderlich.rwnews.ui.list.NewsListView


/**
 * The Presenter for the NewsList
 */
interface NewsListPresenter : Presenter<NewsListModel, NewsListView> {

  /**
   * Invoke in order to display the news
   */
  fun displayNewsList()
}