package com.filipibrentegani.toolsdeveloperandroid

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_show_layout_bounds_demonstration.*


class ShowLayoutBoundsDemonstrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_layout_bounds_demonstration)
    }

    override fun onStart() {
        super.onStart()
        button.setOnClickListener {
            button.animate()
                .translationX(200f)
                .translationY(0f)
                .setDuration(4000)
                .start()


        }

        button2.setOnClickListener {
            button2.animate()
                .alpha(0f)
                .setDuration(1500)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        button2.visibility = View.GONE
                    }
                })
        }
    }
}
