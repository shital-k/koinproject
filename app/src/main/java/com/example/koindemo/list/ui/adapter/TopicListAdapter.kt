package com.example.koindemo.list.ui.adapter

import androidx.databinding.DataBindingUtil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.koindemo.R
import com.example.koindemo.databinding.CardTopicBinding
import com.example.koindemo.list.domain.viewModel.TopicViewModel
import com.example.koindemo.list.model.TopicModel

class TopicListAdapter(
    private val topicList: List<TopicModel>,
    private val topicViewModel: TopicViewModel
) :
    RecyclerView.Adapter<TopicListAdapter.TopicListViewHolder>() {


    override fun getItemCount(): Int {
        return topicList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicListViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.card_topic,
                parent,
                false
            )

        return TopicListViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopicListViewHolder, position: Int) {

        val model = topicList[position]
        holder.bind(model, topicViewModel)
    }


    inner class TopicListViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private var cardTopicBinding: CardTopicBinding? = null

        init {

            cardTopicBinding = DataBindingUtil.bind(itemView)
        }

        fun bind(topicModel: TopicModel, viewModel: TopicViewModel) {

            cardTopicBinding?.apply {

                this.topicViewModel = viewModel

                this.topicModel = topicModel


            }
        }

    }
}