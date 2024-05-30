package com.example.hutchsystemstest

import android.R
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.hutchsystemstest.databinding.ActivityMainBinding
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity(), View.OnTouchListener {

    private lateinit var binding: ActivityMainBinding
private lateinit var myView:MyView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        lifecycleScope.launch {
            val params = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            myView = MyView(this@MainActivity)
            myView.layoutParams = params
            myView.setOnTouchListener(this@MainActivity)
            binding.layoutGraph.addView(myView)
        }

    }



    override fun onTouch(view: View?, event: MotionEvent?): Boolean {
        when (view) {
            myView -> {
                when (event!!.action){
                    MotionEvent.ACTION_DOWN -> {

                        Log.d("Data===", "yeyy")
                    }
                }
            }
        }
        return true
    }
//    override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
//        when (view) {
//            next -> {
//                Log.d("next", "yeyy")
//                when (motionEvent.action){
//                    MotionEvent.ACTION_DOWN -> {
//                        val icon: Drawable = ContextCompat.getDrawable(activity.applicationContext, R.drawable.layer_bt_next)
//                        icon.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY)
//                        next.setImageDrawable(icon)
//                    }
//                    MotionEvent.ACTION_UP -> {
//                        view.performClick()
//                        next.setImageResource(R.drawable.layer_bt_next)
//                    }
//                }
//            }
//            previous -> {
//                //ingredients here XD
//            }
//        }
//        return true
//    }

}