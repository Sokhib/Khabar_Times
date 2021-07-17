package com.tora.khabartimes

import android.os.Bundle
import com.tora.khabartimes.base.BaseActivity
import com.tora.khabartimes.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_KhabarTimes)
        super.onCreate(savedInstanceState)
    }
}