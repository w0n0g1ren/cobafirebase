package com.example.cobafirebase

import android.content.Context
import android.widget.Toast

fun Context.Toast (message : String) {
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}