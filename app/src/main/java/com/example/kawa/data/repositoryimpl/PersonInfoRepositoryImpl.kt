package com.example.kawa.data.repositoryimpl

import com.example.kawa.data.mapper.PersonInfoResponseMapper
import com.example.kawa.data.network.PersonInfoService
import com.example.kawa.domain.Response
import com.example.kawa.domain.model.PersonInfoUiModelResponse
import com.example.kawa.domain.repository.PersonInfoRepository
import javax.inject.Inject

class PersonInfoRepositoryImpl @Inject constructor(
    private val personInfoService: PersonInfoService,
    private val personInfoResponseMapper: PersonInfoResponseMapper
) : PersonInfoRepository {
    override suspend fun getPersonInfoList(
        inc: String,
        results: Int
    ): Response<PersonInfoUiModelResponse> {
        val response = try {
            val resp = personInfoService.getPersonInfoList(
                inc,
                results
            )
            val uiResp = personInfoResponseMapper.mapFrom(resp)
            Response.Success(uiResp)
        } catch (ex: Exception) {
            Response.Failure(ex)
        }
        return response
    }
}