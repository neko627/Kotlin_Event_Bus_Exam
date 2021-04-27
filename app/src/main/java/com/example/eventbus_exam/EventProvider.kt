package com.example.eventbus_exam

import com.squareup.otto.Bus

class Event {
    companion object {
        private val BUS: EventBus = EventBus()

        fun getInstance(): Bus {
            return BUS
        }

        private fun EventProvider() {
            // No instances.
        }
    }
}