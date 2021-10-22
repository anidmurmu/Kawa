package com.example.kawa.domain.usecase

import com.example.kawa.domain.Response
import com.example.kawa.domain.model.PersonInfoUiModelResponse
import com.example.kawa.domain.repository.PersonInfoRepository
import javax.inject.Inject

interface GetPersonInfoListUseCase {
    suspend fun getPersonInfoList(
        inc: String,
        results: Int
    ): Response<PersonInfoUiModelResponse>
}

class GetPersonInfoListUseCaseImpl @Inject constructor(
    private val personRepository: PersonInfoRepository
) : GetPersonInfoListUseCase {
    override suspend fun getPersonInfoList(
        inc: String,
        results: Int
    ): Response<PersonInfoUiModelResponse> {
        return personRepository.getPersonInfoList(inc, results)
    }
}