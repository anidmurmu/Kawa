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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val getPersonInfoListUseCase: GetPersonInfoListUseCase
) : BaseViewModel(application) {

    private val _viewState: MutableLiveData<MainViewState> = MutableLiveData(MainViewState())
    val viewState: LiveData<MainViewState> = _viewState

    fun getPersonInfoList() {
        viewModelScope.launch(Dispatchers.IO) {
            val inc = "gender,name,nat,location,picture,email"
            val results = 20
            when (val resp = getPersonInfoListUseCase.getPersonInfoList(inc, results)) {
                is Response.Success -> {
                    val viewableList = getViewableDataForList(resp.data.personInfoList)
                    updatePersonInfoList(viewableList)
                    Log.d("apple", resp.data.personInfoList.toString())
                }
                is Response.Failure -> {
                    Log.d("apple", resp.error.toString())
                }
            }
        }
    }

    private fun getViewableDataForList(personInfoList: List<PersonInfoUiModel>): List<BaseBindingRVModel> {
        return personInfoList.map {
            UnselectedListItemRVModel(it)
        }
    }

    private fun updatePersonInfoList(list: List<BaseBindingRVModel>) {
        Log.d("apple list", list[1].toString())
        _viewState.value?.personInfoList?.postValue(list)
        Log.d("apple size", _viewState.value?.personInfoList?.value?.size?.toString() + "")
    }

}