package com.example.kawa.ui.infolist

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kawa.R
import com.example.kawa.domain.Response
import com.example.kawa.domain.model.PersonInfoUiModel
import com.example.kawa.domain.usecase.GetPersonInfoListUseCase
import com.example.kawa.ui.base.Event
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

    private val _viewEvent: MainEvent = MainEvent()
    val viewEvent = _viewEvent

    fun getPersonInfoList() {
        viewModelScope.launch(Dispatchers.IO) {
            val inc = "gender,name,nat,location,picture,email"
            val results = 20
            when (val resp = getPersonInfoListUseCase.getPersonInfoList(inc, results)) {
                is Response.Success -> {
                    val viewableList = getViewableDataForList(resp.data.personInfoList, 0)
                    updatePersonInfoList(viewableList)
                    _viewState.value?.personInfoListCarousel?.postValue(resp.data.personInfoList)
                }
                is Response.Failure -> {
                    Log.d("MainViewModel", resp.error.toString())
                }
            }
        }
    }

    fun getViewableDataForList(
        personInfoList: List<PersonInfoUiModel>,
        selectedPosition: Int
    ): List<BaseBindingRVModel> {
        val newList = ArrayList<BaseBindingRVModel>()
        personInfoList.forEachIndexed { index, personInfoUiModel ->
            if (index == selectedPosition) {
                newList.add(SelectedListItemRVModel(personInfoUiModel))
            } else {
                newList.add(UnselectedListItemRVModel(personInfoUiModel))
            }
        }
        return newList
    }

    fun updatePersonInfoList(list: List<BaseBindingRVModel>) {
        _viewState.value?.personInfoList?.postValue(list)
    }

    fun getSelectedPosition(): Int {
        return _viewState.value?.selectedPosition?.value ?: -1
    }

    override fun onViewClick(id: Int, data: Any) {
        when (id) {
            R.id.on_click_item -> {
                val position = data as Int
                viewState.value?.personInfoListCarousel?.value?.let {
                    val viewableList = getViewableDataForList(it, position)
                    updatePersonInfoList(viewableList)
                    _viewState.value?.selectedPosition?.value = position
                    viewEvent.itemListClickEvent.postValue(Event(true))
                }
            }
        }
    }
}