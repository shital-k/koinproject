package com.example.koindemo.list.domain.interactor

import com.example.koindemo.list.domain.repository.TopicRepository
import com.example.koindemo.list.model.TopicModel
import com.example.koindemo.utils.NetworkResult

class GetTopicList(private val topicRepository: TopicRepository) {
    suspend operator fun invoke(): List<TopicModel> {
        return topicRepository.getTopicList()
    }
}