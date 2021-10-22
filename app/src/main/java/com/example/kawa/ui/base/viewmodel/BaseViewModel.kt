package com.example.kawa.ui.base.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavDirections
import com.example.kawa.ui.base.ViewOnClickListener
import com.example.kawa.ui.base.navigation.NavigationCommand
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application), ViewOnClickListener {

    private val _navigationCommand: MutableLiveData<NavigationCommand> = MutableLiveData()
    val navigationCommandLiveData: LiveData<NavigationCommand> = _navigationCommand
    override fun onViewClick(id: Int, data: Any) {}

    fun navigate(directions: NavDirections) {
        _navigationCommand.postValue(NavigationCommand.To(directions))
    }

    fun exitActivity() {
        _navigationCommand.postValue(NavigationCommand.ToRoot)
    }
}
