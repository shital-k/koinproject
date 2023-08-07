package com.example.koindemo.list.data.remote_service

import com.example.koindemo.list.model.TopicModel
import retrofit2.Response
import retrofit2.http.GET

interface TopicRemoteService {

    @GET("Courses/GetTopic/33849/2")
    suspend fun getTopicList(): Response<List<TopicModel>>
}