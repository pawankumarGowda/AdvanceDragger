package com.raywenderlich.rwnews.ui.detail

import com.raywenderlich.common.mvp.View
import com.raywenderlich.rwnews.repository.entity.News
import com.raywenderlich.rwnews.model.NewsModel


/**
 * The View for the Detail
 */
interface NewsDetailView : View<NewsModel> {

  /**
   * Displays the given News
   */
  fun displayNews(news: News)
}