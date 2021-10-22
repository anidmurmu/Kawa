package com.example.kawa.domain.repository

import com.example.kawa.domain.Response
import com.example.kawa.domain.model.PersonInfoUiModelResponse

interface PersonInfoRepository {
    suspend fun getPersonInfoList(
        inc: String,
        results: Int
    ): Response<PersonInfoUiModelResponse>
}