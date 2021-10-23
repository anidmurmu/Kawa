package com.example.kawa.data.network

import com.example.kawa.data.entity.PersonInfoNetworkModelResponse
import retrofit2.http.*

// https://randomuser.me/api/?inc=gender,name,nat,location,picture,email&results=20

interface PersonInfoService {
    @GET(".")
    suspend fun getPersonInfoList(
        @Query("inc") inc: String,
        @Query("results") results: Int
    ): PersonInfoNetworkModelResponse
}