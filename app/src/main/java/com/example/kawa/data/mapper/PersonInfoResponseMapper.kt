package com.example.kawa.data.mapper

import com.example.kawa.data.entity.PersonInfoNetworkModel
import com.example.kawa.data.entity.PersonInfoNetworkModelResponse
import com.example.kawa.domain.model.PersonInfoUiModel
import com.example.kawa.domain.model.PersonInfoUiModelResponse
import com.example.kawa.ui.base.Mapper
import javax.inject.Inject


class PersonInfoResponseMapper @Inject constructor() :
    Mapper<PersonInfoNetworkModelResponse, PersonInfoUiModelResponse> {
    override fun mapFrom(sourceModel: PersonInfoNetworkModelResponse): PersonInfoUiModelResponse {
        return mapToUiModel(sourceModel)
    }

    private fun mapToUiModel(source: PersonInfoNetworkModelResponse): PersonInfoUiModelResponse {
        return PersonInfoUiModelResponse(
            mapToUiModelList(source.results)
        )
    }

    private fun mapToUiModelList(source: List<PersonInfoNetworkModel>): List<PersonInfoUiModel> {
        return source.map {
            PersonInfoUiModel(
                it.gender.replaceFirstChar {
                        ch -> ch.uppercaseChar()
                } + " . " + it.nationality,
                it.name.title + ". " + it.name.first + " " + it.name.last,
                it.email,
                it.location.street.number,
                it.location.street.name,
                it.location.country,
                it.location.postcode,
                it.location.timezone.offset,
                it.location.timezone.description,
                it.gender
            )
        }
    }
}