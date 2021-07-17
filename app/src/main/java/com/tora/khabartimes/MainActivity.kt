package com.tora.khabartimes

import android.os.Bundle
import com.tora.khabartimes.base.BaseActivity
import com.tora.khabartimes.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_KhabarTimes)
        super.onCreate(savedInstanceState)

        Timber.d("API key: ${stringFromJNI()}")
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}