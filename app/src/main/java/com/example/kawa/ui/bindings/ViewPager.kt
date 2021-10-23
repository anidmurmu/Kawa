package com.example.kawa.ui.bindings

import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.kawa.ui.base.RVModelBindingAdapter
import com.example.kawa.ui.base.recyclerview.BaseBindingRVModel
import com.example.kawa.ui.base.recyclerview.BaseRVBindingAdapter

@BindingAdapter("data")
fun <T : BaseBindingRVModel> setViewPagerProperties(viewPager: ViewPager2, data: List<T>?) {
    data?.let {
        if (viewPager.adapter is BaseRVBindingAdapter<*>) {
            (viewPager.adapter as RVModelBindingAdapter).setItems(data)
        }
    }
}