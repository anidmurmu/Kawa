package com.example.kawa.domain.repository

import com.example.kawa.domain.Response
import com.example.kawa.domain.model.PersonInfoUiModel

interface PersonRepository {
    suspend fun getPersonInfoList(): Response<List<PersonInfoUiModel>>
}