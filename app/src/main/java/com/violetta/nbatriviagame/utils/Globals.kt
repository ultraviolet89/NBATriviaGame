package com.violetta.nbatriviagame.utils

import android.app.Activity
import android.view.View
import com.violetta.nbatriviagame.R

/**
 * Provides global utility functions and constants used across the application.
 *
 * This object contains methods and properties that are globally accessible within the app.
 * These might include configuration settings, utility functions, and constants.
 */
object Globals {
    /**
     * Sets a random background for the given activity.
     * @param activity The activity for which the background is to be set.
     */
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