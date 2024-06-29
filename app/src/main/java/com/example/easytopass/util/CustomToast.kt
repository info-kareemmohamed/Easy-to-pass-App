package com.example.easytopass.util

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.easytopass.R

class CustomToast {
    companion object {
        fun showToast(
            context: Context,
            message: String,
            textIcon: String,
            layoutBackground: Int,
            duration: Int
        ) {
            val layoutInflater: LayoutInflater = LayoutInflater.from(context)
            val view = layoutInflater.inflate(R.layout.custom_toast_layout, null)

            view.findViewById<TextView>(R.id.toast_text_icon).text = textIcon
            view.findViewById<TextView>(R.id.toast_text).text = message
            view.findViewById<LinearLayout>(R.id.toast_layout).background = ContextCompat.getDrawable(context, layoutBackground)

            val toast = Toast(context)
            toast.duration = duration
            toast.view = view
            toast.show()
        }
    }
}