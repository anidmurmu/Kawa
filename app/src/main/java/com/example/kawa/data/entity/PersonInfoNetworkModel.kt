package com.example.kawa.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PersonInfoNetworkModelResponse(
    @SerializedName("results")
    @Expose
    val results: List<PersonInfoNetworkModel>
)

data class PersonInfoNetworkModel(
    @SerializedName("gender")
    @Expose
    val gender: String
)
