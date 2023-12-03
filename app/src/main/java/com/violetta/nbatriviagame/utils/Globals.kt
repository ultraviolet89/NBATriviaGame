package com.violetta.nbatriviagame.utils

import android.app.Activity
import android.view.View
import com.violetta.nbatriviagame.R

object Globals {
    fun setRandomBackground(activity: Activity) {
        val backgrounds = listOf(
            R.drawable.bg_1,
            R.drawable.bg_2,
            R.drawable.bg_3
        )
        val randomBackground = backgrounds.random()
        val rootView = activity.findViewById<View>(android.R.id.content)
        rootView.setBackgroundResource(randomBackground)
    }
}