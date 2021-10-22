package com.example.kawa.ui.infolist

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.kawa.domain.Response
import com.example.kawa.domain.usecase.GetPersonInfoListUseCase
import com.example.kawa.ui.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val getPersonInfoListUseCase: GetPersonInfoListUseCase
) : BaseViewModel(application) {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val inc = "gender"
            val results = 20
            val resp = getPersonInfoListUseCase.getPersonInfoList(inc, results)
            when(resp) {
                is Response.Success -> {
                    Log.d("apple", resp.data.personInfoList.toString())
                }
                is Response.Failure -> {
                    Log.d("apple", resp.error.toString())
                }
            }
        }
    }

}