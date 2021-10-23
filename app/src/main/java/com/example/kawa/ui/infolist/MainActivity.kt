package com.example.kawa.ui.infolist

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.kawa.R
import com.example.kawa.databinding.ActivityMainBinding
import com.example.kawa.ui.base.RVModelBindingAdapter
import dagger.hilt.android.AndroidEntryPoint

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

        model.getPersonInfoList()
    }
}