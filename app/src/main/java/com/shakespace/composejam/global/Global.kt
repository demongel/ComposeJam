package com.shakespace.composejam.global

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast


fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Context.start(clazz: Class<*>, bundle: Bundle? = null) {
    startActivity(Intent(this, clazz).also {
        if (bundle != null) {
            it.putExtra("bundle", bundle)
        }
    })
}
