package com.example.koindemo.list.domain.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koindemo.list.domain.interactor.GetTopicList
import com.example.koindemo.list.model.TopicModel
import kotlinx.coroutines.launch

class TopicViewModel(private val getTopicList: GetTopicList) : ViewModel() {

    var list: MutableLiveData<List<TopicModel>?>? = MutableLiveData(listOf())

    init {
        getList()
    }

    private fun getList() {

        try {
            viewModelScope.launch {

                list?.postValue(getTopicList())

            }
        } catch (e: Exception) {
            println("get topic list : ${e.message}")

        }
    }
}