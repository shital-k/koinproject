package com.example.koinapp.data.di

import android.provider.ContactsContract.CommonDataKinds.Identity.IDENTITY
import com.google.gson.FieldNamingStrategy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilderClass {


 /*   fun providerGson(): Gson {
        return GsonBuilder().setFieldNamingStrategy(FieldNamingStrategy.IDENTITY).create()
    }*/

    fun providerHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        return okHttpClientBuilder.build()
    }

    fun providerRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl("https://webapp.classroomplus.in:8443/Course/uat/api")
            .addConverterFactory(GsonConverterFactory.create(factory)).client(client).build()
    }


}