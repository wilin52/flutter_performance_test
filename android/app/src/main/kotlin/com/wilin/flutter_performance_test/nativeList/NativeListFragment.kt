package com.wilin.flutter_performance_test.nativeList

import NativeListAdapter
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wilin.flutter_performance_test.R

class NativeListFragment : Fragment() {
  private lateinit var recyclerView: RecyclerView
  private lateinit var scrollBtn: FloatingActionButton

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.native_list_fragment, null)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    recyclerView = view.findViewById(R.id.fragment_recycler_view)
    val linearLayoutManager = LinearLayoutManager(context)
    val density = context?.resources?.displayMetrics?.density ?: 1f
    recyclerView.layoutManager = linearLayoutManager
    recyclerView.adapter = NativeListAdapter(1000)
    scrollBtn = view.findViewById(R.id.native_scroll_btn)
    scrollBtn.setOnClickListener {
      if(linearLayoutManager.findFirstVisibleItemPosition() != 0) {
        recyclerView.smoothScrollToPosition(0)
      } else {
        recyclerView.smoothScrollBy(0, (10000 * density).toInt())
      }
    }
  }
}