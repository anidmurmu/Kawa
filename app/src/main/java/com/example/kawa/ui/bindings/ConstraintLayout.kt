package com.ather.dashboard.tron.utils.bindings

import androidx.annotation.ColorInt
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter

@BindingAdapter("backgroundColor")
fun setBackgroundColor(view: ConstraintLayout, @ColorInt colorId: Int) {
    view.setBackgroundColor(colorId)
}