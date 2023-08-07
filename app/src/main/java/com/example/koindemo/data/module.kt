package com.example.koindemo.data

import com.example.koindemo.list.data.remote_service.TopicRemoteService
import com.example.koindemo.list.domain.TopicRepositoryImpl
import com.example.koindemo.list.domain.interactor.GetTopicList
import com.example.koindemo.list.domain.repository.TopicRepository
import com.example.koindemo.list.domain.viewModel.TopicViewModel
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val retrofitInstance = module {
    single {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        Retrofit.Builder().baseUrl("https://webapp.classroomplus.in:8443/Course/uat/api/")
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setFieldNamingPolicy(
                        FieldNamingPolicy.IDENTITY
                    ).create()
                )
            )
            .client(client).build()
    }
}

val getTopicListModule = module {

    single { get<Retrofit>().create(TopicRemoteService::class.java) }

    single<TopicRepository> { TopicRepositoryImpl(get()) }

    single { GetTopicList(get()) }

    viewModel { TopicViewModel(get()) }

}