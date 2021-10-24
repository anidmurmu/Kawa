package com.example.kawa.ui.infolist

import androidx.lifecycle.MutableLiveData
import com.example.kawa.ui.base.Event
import javax.inject.Inject

class MainEvent @Inject constructor() {
    val itemListClickEvent = MutableLiveData<Event<Boolean>>()
}