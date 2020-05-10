package com.raywenderlich.rwnews.model

import com.raywenderlich.common.mvp.Model
import com.raywenderlich.rwnews.repository.entity.News

/**
 * Model for the NewsList
 */
data class NewsListModel(var newsList: List<News>) : Model