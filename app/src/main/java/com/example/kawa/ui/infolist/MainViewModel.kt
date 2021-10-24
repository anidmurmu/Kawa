package com.example.kawa.ui.infolist

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kawa.domain.Response
import com.example.kawa.domain.model.PersonInfoUiModel
import com.example.kawa.domain.usecase.GetPersonInfoListUseCase
import com.example.kawa.ui.base.recyclerview.BaseBindingRVModel
import com.example.kawa.ui.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val getPersonInfoListUseCase: GetPersonInfoListUseCase
) : BaseViewModel(application) {

    private val _viewState: MutableStateFlow<MainViewState> = MutableStateFlow(MainViewState.InitialState)
    val viewState: StateFlow<MainViewState> = _viewState

    fun getPersonInfoList() {
        viewModelScope.launch(Dispatchers.IO) {
            val inc = "gender,name,nat,location,picture,email"
            val results = 20
            when (val resp = getPersonInfoListUseCase.getPersonInfoList(inc, results)) {
                is Response.Success -> {
                    val viewableList = getViewableDataForList(resp.data.personInfoList)
                    updatePersonInfoList(viewableList)
                    updateViewState(MainViewState.HasDataState(resp.data.personInfoList))
                    Log.d("apple", resp.data.personInfoList.toString())
                }
                is Response.Failure -> {
                    Log.d("MainViewModel", resp.error.toString())
                }
            }
        }
    }

    fun getPersonInfoListSize(): Int {
        return _viewState.value.personInfoList.value?.size ?: 0
    }

    private fun updateViewState(viewState: MainViewState) {
        _viewState.value = viewState
    }

    fun getViewableDataForList(personInfoList: List<PersonInfoUiModel>): List<BaseBindingRVModel> {
        return personInfoList.map {
            UnselectedListItemRVModel(it)
        }
    }

    private fun updatePersonInfoList(list: List<BaseBindingRVModel>) {
        _viewState.value.personInfoList.postValue(list)
    }

}