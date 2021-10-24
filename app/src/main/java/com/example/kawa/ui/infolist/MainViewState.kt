package com.example.kawa.ui.infolist

import androidx.lifecycle.MutableLiveData
import com.example.kawa.domain.model.PersonInfoUiModel
import com.example.kawa.ui.base.recyclerview.BaseBindingRVModel

sealed class MainViewState {
    val personInfoList: MutableLiveData<List<BaseBindingRVModel>> = MutableLiveData(mutableListOf())
    val genderAndNationality: MutableLiveData<String> = MutableLiveData("")
    val fullName: MutableLiveData<String> = MutableLiveData("")
    val email: MutableLiveData<String> = MutableLiveData("")

    object InitialState: MainViewState()
    data class HasDataState(val personInfoUiModelList: List<PersonInfoUiModel>): MainViewState()
}