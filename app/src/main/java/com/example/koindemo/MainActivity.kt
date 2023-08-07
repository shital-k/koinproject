package com.example.koindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.koindemo.databinding.ActivityMainBinding
import com.example.koindemo.list.domain.viewModel.TopicViewModel
import com.example.koindemo.list.model.TopicModel
import com.example.koindemo.list.ui.adapter.TopicListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<TopicViewModel>()

    private var activityMainBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        callViewModel()
    }

    private fun callViewModel() {
        viewModel.list?.observe(this@MainActivity, Observer {
            it?.let { list ->
                if (list.isNotEmpty()) {
                    print("list of topic : ${list.size}")

                    setAdapter(list)
                }
            }
        })
    }

    private fun setAdapter(list: List<TopicModel>) {


        val topicListAdapter = TopicListAdapter(list, viewModel)

        activityMainBinding?.apply {

            val layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)

            rvList.apply {
                this.layoutManager = layoutManager
                adapter = topicListAdapter

            }
        }
    }
}