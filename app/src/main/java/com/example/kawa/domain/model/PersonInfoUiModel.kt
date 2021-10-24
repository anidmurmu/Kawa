package com.example.kawa.domain.model

data class PersonInfoUiModelResponse(
    val personInfoList: List<PersonInfoUiModel>
)

/*data class PersonInfoUiModel(
    val gender: String,
    val titleName: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val nationality: String
)*/
data class PersonInfoUiModel(
    val genderAndNat: String,
    val name: String,
    val email: String,
    val streetNumber: String,
    val streetName: String
)
