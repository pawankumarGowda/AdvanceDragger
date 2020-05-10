package com.raywenderlich.rwnews.ui.list

import com.raywenderlich.common.mvp.View
import com.raywenderlich.rwnews.model.NewsListModel


/**
 * This is a View in a MVP architecture for News list
 */
interface NewsListView : View<NewsListModel> {

  /**
   * Displays the list of news in the View
   */
  fun displayNews(newsList: NewsListModel)
}