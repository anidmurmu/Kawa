package com.example.kawa.domain.usecase

import com.example.kawa.domain.Response
import com.example.kawa.domain.model.PersonInfoUiModel
import com.example.kawa.domain.repository.PersonRepository
import javax.inject.Inject

interface GetPersonInfoListUseCase {
    suspend fun getPersonInfoList(): Response<List<PersonInfoUiModel>>
}

class GetPersonInfoListUseCaseImpl @Inject constructor(
    private val personRepository: PersonRepository
) : GetPersonInfoListUseCase {
    override suspend fun getPersonInfoList(): Response<List<PersonInfoUiModel>> {
        return personRepository.getPersonInfoList()
    }
}