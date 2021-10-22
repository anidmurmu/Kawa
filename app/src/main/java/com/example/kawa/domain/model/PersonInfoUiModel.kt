package com.example.kawa.domain.model

data class PersonInfoUiModelResponse(
    val personInfoList: List<PersonInfoUiModel>
)

data class PersonInfoUiModel(val gender: String)
