package com.raywenderlich.rwnews.model

import com.raywenderlich.common.mvp.Model
import com.raywenderlich.rwnews.repository.entity.News


/**
 * The Model for the news
 */
data class NewsModel(val news: News) : Model