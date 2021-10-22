package com.example.kawa.ui.base.recyclerview

import androidx.databinding.ViewDataBinding
import com.example.kawa.ui.base.ViewOnClickListener

abstract class BaseViewHolderBindingFactory {
    abstract fun create(
        binding: ViewDataBinding,
        viewType: Int,
        viewClickCallback: ViewOnClickListener?
    ): BaseBindingViewHolder<out BaseBindingRVModel>
}
