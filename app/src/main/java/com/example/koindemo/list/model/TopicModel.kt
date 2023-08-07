package com.example.koindemo.list.model


import com.google.gson.annotations.SerializedName


data class TopicModel(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("topic_Name") var topicName: String? = null,
    @SerializedName("topic_Hours") var topicHours: Int? = null,
    @SerializedName("topic_Minutes") var topicMinutes: Int? = null,
    @SerializedName("attachmentForSlef") var attachmentForSlef: String? = null,
    @SerializedName("studyMaterialForStudents") var studyMaterialForStudents: String? = null,
    @SerializedName("assignmentCount") var assignmentCount: Int? = null,
    @SerializedName("caseStudyCount") var caseStudyCount: Int? = null,
    @SerializedName("presentationCount") var presentationCount: Int? = null,
    @SerializedName("pre_ReadingCount") var preReadingCount: Int? = null

)