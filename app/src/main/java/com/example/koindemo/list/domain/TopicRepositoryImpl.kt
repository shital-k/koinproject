package com.example.koindemo.list.domain

import com.example.koindemo.list.data.remote_service.TopicRemoteService
import com.example.koindemo.list.domain.repository.TopicRepository
import com.example.koindemo.list.model.TopicModel
import java.io.IOException

class TopicRepositoryImpl(private val topicRemoteService: TopicRemoteService) : TopicRepository {
    override suspend fun getTopicList(): List<TopicModel> {
        try {

            val res = topicRemoteService.getTopicList().body()
            println("get topic list : ${res?.size}")

            return res!!

        } catch (e: Exception) {
            e.printStackTrace()
            throw IOException(e.message)
        }
    }
}