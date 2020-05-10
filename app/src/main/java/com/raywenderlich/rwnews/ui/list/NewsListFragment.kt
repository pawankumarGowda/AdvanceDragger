package com.raywenderlich.news.android.ui.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.rwnews.R
import com.raywenderlich.rwnews.init.InitApp
import com.raywenderlich.rwnews.model.NewsListModel
import com.raywenderlich.rwnews.presenter.NewsListPresenter
import com.raywenderlich.rwnews.ui.detail.NewsDetailFragment
import com.raywenderlich.rwnews.ui.list.NewsListView
import javax.inject.Inject


/**
 * This is the Fragment for displaying the list of news
 */
class NewsListFragment : Fragment(), NewsListView {

  @Inject
  lateinit var newsListPresenter: NewsListPresenter

  private lateinit var recyclerView: RecyclerView
  private lateinit var newsListViewAdapter: NewsListViewAdapter
  private val newsListModel = NewsListModel(emptyList())

  override fun onAttach(context: Context) {
    (context.applicationContext as InitApp) // HERE
      .appComp().inject(this)
    super.onAttach(context)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.news_list_layout, container, false)
    newsListPresenter.bind(this)
    initRecyclerView(view)
    return view
  }

  override fun onStart() {
    super.onStart()
    newsListPresenter.displayNewsList()
  }

  override fun displayNews(newsList: NewsListModel) {
    newsListModel.newsList = newsList.newsList
    newsListViewAdapter.notifyDataSetChanged()
  }

  override fun onDestroy() {
    super.onDestroy()
    newsListPresenter.unbind()
  }

  private fun initRecyclerView(view: View) {
    recyclerView = view.findViewById(R.id.recycler_view)
    recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    val dividerItemDecoration = DividerItemDecoration(
      context,
      LinearLayoutManager.VERTICAL
    )
    recyclerView.addItemDecoration(dividerItemDecoration)
    newsListViewAdapter = NewsListViewAdapter(newsListModel) { selectedNews ->
      val bundle = Bundle().apply {
        putLong(NewsDetailFragment.NEWS_ID, selectedNews?.id ?: -1)
      }
      fragmentManager?.run {
        beginTransaction()
          .replace(R.id.anchor, NewsDetailFragment.create(bundle))
          .addToBackStack(null)
          .commit()
      }
    }
    recyclerView.adapter = newsListViewAdapter
  }
}