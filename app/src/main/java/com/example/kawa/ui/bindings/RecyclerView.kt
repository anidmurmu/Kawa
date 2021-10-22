package com.ather.dashboard.tron.utils.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kawa.ui.base.RVModelBindingAdapter
import com.example.kawa.ui.base.recyclerview.BaseBindingRVModel
import com.example.kawa.ui.base.recyclerview.BaseRVBindingAdapter

@BindingAdapter("data")
fun <T : BaseBindingRVModel> setRecyclerViewProperties(recyclerView: RecyclerView, data: List<T>?) {
    data?.let {
        if (recyclerView.adapter is BaseRVBindingAdapter<*>) {
            (recyclerView.adapter as RVModelBindingAdapter).setItems(data)
        }
    }
}

@BindingAdapter("adapter")
fun <T : RVModelBindingAdapter> setAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
    recyclerView.adapter = adapter
}