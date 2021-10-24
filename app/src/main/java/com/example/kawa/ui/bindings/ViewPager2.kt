package com.example.kawa.ui.bindings

import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.kawa.ui.base.RVModelBindingAdapter
import com.example.kawa.ui.base.recyclerview.BaseBindingRVModel
import com.example.kawa.ui.base.recyclerview.BaseRVBindingAdapter

@BindingAdapter("viewPagerData")
fun <T : BaseBindingRVModel> setViewPager2Properties(viewPager2: ViewPager2, data: List<T>?) {
    data?.let {
        if (viewPager2.adapter is BaseRVBindingAdapter<*>) {
            (viewPager2.adapter as RVModelBindingAdapter).setItems(data)
        }
    }
}