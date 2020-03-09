package com.monachrom.shinycount.main.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.monachrom.shinycount.R
import com.monachrom.shinycount.main.ui.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}
