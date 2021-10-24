package com.example.kawa.ui.infolist

import androidx.lifecycle.MutableLiveData
import com.example.kawa.domain.model.PersonInfoUiModel
import com.example.kawa.ui.base.recyclerview.BaseBindingRVModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewState {
    val personInfoList: MutableLiveData<List<BaseBindingRVModel>> = MutableLiveData(mutableListOf())
    val personInfoListCarousel: MutableLiveData<List<PersonInfoUiModel>> = MutableLiveData(mutableListOf())
    val selectedPosition: MutableStateFlow<Int> = MutableStateFlow(-1)
}