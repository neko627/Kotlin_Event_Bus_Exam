package com.example.eventbus_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.squareup.otto.Subscribe

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var text: TextView

    private val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Event.getInstance().register(this)

        button = findViewById(R.id.button)
        text = findViewById(R.id.text)

        button.setOnClickListener {
            Log.d("@@@", "Button Click")
            Event.getInstance().post(Event())
        }
    }

    @Subscribe
    fun receiveEvent(event: Event) {
        text.text = "버튼 클릭 이벤트 발생"
        Log.d(TAG, "Event 호출")
    }

    override fun onDestroy() {
        super.onDestroy()
        Event.getInstance().unregister(this)
    }
}