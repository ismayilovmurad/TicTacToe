package com.martiandeveloper.tictactoegame.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.martiandeveloper.tictactoegame.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
    }

    private fun initUI() {
        window.setBackgroundDrawableResource(R.drawable.background)
        setContentView(R.layout.activity_main)
    }

}
