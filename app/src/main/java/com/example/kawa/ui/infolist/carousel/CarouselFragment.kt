package com.example.kawa.ui.infolist.carousel

import com.example.kawa.R
import com.example.kawa.databinding.FragmentCarouselBinding
import com.example.kawa.ui.base.RVModelBindingAdapter
import com.example.kawa.ui.base.fragment.DataBindingBaseFragment
import com.example.kawa.ui.infolist.MainVHFactory
import com.example.kawa.ui.infolist.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CarouselFragment(private val viewModel: MainViewModel) :
    DataBindingBaseFragment<FragmentCarouselBinding>() {

    override val layoutResource: Int
        get() = R.layout.fragment_carousel

    override fun onViewDataBindingCreated(binding: FragmentCarouselBinding) {
        binding.viewModel = viewModel
        binding.rvCarouselList.adapter = RVModelBindingAdapter(
            viewModel.viewState.value.personInfoList.value ?: emptyList(),
            viewModel,
            MainVHFactory()
        )
    }
}