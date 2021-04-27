package com.example.eventbus_exam

import android.os.Handler
import android.os.Looper
import com.squareup.otto.Bus

class EventBus: Bus() {
    private val mHandler = Handler(Looper.getMainLooper())

//    override fun post(event: Any?) {
//        super.post(event)
//    }

    override fun post(event: Any?) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.post(event)
        } else {
            mHandler.post { super@EventBus.post(event) }
        }
    }
}