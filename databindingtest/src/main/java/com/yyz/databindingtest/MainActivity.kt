package com.yyz.databindingtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.yyz.databindingtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mLiveDataViewModel: LiveDataViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mLiveDataViewModel = ViewModelProviders.of(this).get(LiveDataViewModel::class.java)
        binding.result = mLiveDataViewModel
        binding.lifecycleOwner = this
    }
}
