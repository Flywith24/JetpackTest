package com.yyz.livedatatest

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.yyz.livedatatest.viewmodel.LiveDataViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mLiveDataViewModel: LiveDataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mLiveDataViewModel = ViewModelProviders.of(this).get(LiveDataViewModel::class.java)
        val text = findViewById<TextView>(R.id.textView)
        text.text = mLiveDataViewModel.favoriteNum.value.toString()
        mLiveDataViewModel.favoriteNum.observe(this, Observer<Int> {
            text.text = mLiveDataViewModel.favoriteNum.value.toString()
        })
        findViewById<ImageButton>(R.id.ibLike).setOnClickListener {
            mLiveDataViewModel.addFavoriteNum(1)
        }
        findViewById<ImageButton>(R.id.ibDislike).setOnClickListener {
            mLiveDataViewModel.addFavoriteNum(-1)
        }
    }
}
