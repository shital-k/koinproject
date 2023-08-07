package com.example.koindemo.list.domain.repository

import com.example.koindemo.list.model.TopicModel
import com.example.koindemo.utils.NetworkResult

interface TopicRepository {


    suspend fun getTopicList(): List<TopicModel>
}