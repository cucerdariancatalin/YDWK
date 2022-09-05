/*
 * Copyright 2022 Yusuf Arfan Ismail and other YDWK contributors.
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 
package io.github.realyusufismail.ydwk.impl.event.handle.config

import io.github.realyusufismail.ydwk.impl.event.Event

class EventReceiver : IEventReceiver {
    // Null as there is no default value for this parameter
    var event: Event? = null
    var eventReceivers: MutableList<IEvent> = ArrayList()

    override fun handleEvent(event: Event) {
        for (eventReceiver in eventReceivers) {
            eventReceiver.onEvent(event)
        }
    }

    /** Add an event receiver to the list of event receivers */
    override fun addEventReceiver(eventReceiver: Any) {
        if (eventReceiver is IEvent) {
            eventReceivers.add(eventReceiver)
        } else {
            throw IllegalArgumentException("EventReceiver must be instance of IEventReceiver")
        }
    }

    /** Remove an event receiver from the list of event receivers */
    override fun removeEventReceiver(eventReceiver: Any) {
        if (eventReceiver is IEvent) {
            eventReceivers.remove(eventReceiver)
        } else {
            throw IllegalArgumentException("EventReceiver must be instance of IEventReceiver")
        }
    }
}
