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

class PlainEventReceiver(val eventReceiver: IEventReceiver) : IEventReceiver {

    override fun addEventReceiver(eventReceiver: Any) {
        this.eventReceiver.addEventReceiver(eventReceiver)
    }

    override fun removeEventReceiver(eventReceiver: Any) {
        this.eventReceiver.removeEventReceiver(eventReceiver)
    }

    override fun handleEvent(event: Event) {
        try {
            this.eventReceiver.handleEvent(event)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
