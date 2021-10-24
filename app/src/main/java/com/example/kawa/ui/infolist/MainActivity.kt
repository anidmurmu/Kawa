package com.example.kawa.ui.infolist

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.kawa.R
import com.example.kawa.databinding.ActivityMainBinding
import com.example.kawa.ui.base.RVModelBindingAdapter
import com.example.kawa.ui.infolist.carousel.ViewPagerFragmentStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = model
        binding.lifecycleOwner = this

        binding.rvPersonInfo.adapter = RVModelBindingAdapter(
            emptyList(),
            model,
            MainVHFactory()
        )

        binding.viewPager.adapter = RVModelBindingAdapter(
            emptyList(),
            model,
            MainVHFactory()
        )

        model.getPersonInfoList()


            /*binding.viewPager.adapter = ViewPagerFragmentStateAdapter(
                this@MainActivity,
                model,
                model.getPersonInfoListSize()
            )*/

        /*lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                model.viewState.collect { uiState ->
                    when (uiState) {
                        is MainViewState.InitialState -> {
                        }

                        is MainViewState.HasDataState -> {
                            *//*binding.viewPager.adapter = ViewPagerFragmentStateAdapter(
                                this@MainActivity,
                                model,
                                model.getPersonInfoListSize()
                            )*//*
                            val personInfoViewableList = model.getViewableDataForList(uiState.personInfoUiModelList)

                            binding.viewPager.adapter = RVModelBindingAdapter(
                                personInfoViewableList,
                                model,
                                MainVHFactory()
                            )

                            //binding.viewPager.adapter = CarouselAdapter(uiState.personInfoUiModelList)
                            Log.d("apple", uiState.personInfoUiModelList.toString())
                        }
                    }
                }
            }
        }*/

    }
}