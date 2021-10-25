package com.example.kawa.ui.infolist

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.kawa.R
import com.example.kawa.databinding.ActivityMainBinding
import com.example.kawa.ui.base.RVModelBindingAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = model
        binding.lifecycleOwner = this

        binding.rvPersonInfo.adapter = RVModelBindingAdapter(
            emptyList(),
            model,
            MainVHFactory()
        )

        model.getPersonInfoList()

        model.viewState.value?.personInfoListCarousel?.observe(this, {
            binding.viewPager.adapter = CarouselAdapter(it)
        })

        model.viewEvent.itemListClickEvent.observe(this, {
            val selectedPosition = model.getSelectedPosition()
            binding.viewPager.setCurrentItem(selectedPosition, true)
        })

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                model.viewState.value?.personInfoListCarousel?.value?.let {
                    val viewableList = model.getViewableDataForList(it, position)
                    model.updatePersonInfoList(viewableList)
                    binding.rvPersonInfo.scrollToPosition(position)
                }
            }
        })
    }
}