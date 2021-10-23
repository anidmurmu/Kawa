package com.example.kawa.ui.infolist

import androidx.lifecycle.MutableLiveData
import com.example.kawa.ui.base.recyclerview.BaseBindingRVModel

class MainViewState {
    val personInfoList: MutableLiveData<List<BaseBindingRVModel>> = MutableLiveData(emptyList())
    val genderAndNationality: MutableLiveData<String> = MutableLiveData("")
    val fullName: MutableLiveData<String> = MutableLiveData("")
    val email: MutableLiveData<String> = MutableLiveData("")
}