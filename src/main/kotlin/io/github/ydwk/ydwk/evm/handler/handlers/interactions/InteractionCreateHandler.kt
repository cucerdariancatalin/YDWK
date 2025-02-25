/*
 * Copyright 2022 YDWK inc.
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
package io.github.ydwk.ydwk.evm.handler.handlers.interactions

import com.fasterxml.jackson.databind.JsonNode
import io.github.ydwk.ydwk.evm.handler.Handler
import io.github.ydwk.ydwk.impl.YDWKImpl
import io.github.ydwk.ydwk.impl.interaction.InteractionImpl
import io.github.ydwk.ydwk.interaction.Interaction
import io.github.ydwk.ydwk.interaction.sub.InteractionType

class InteractionCreateHandler(ydwk: YDWKImpl, json: JsonNode) : Handler(ydwk, json) {
    override fun start() {
        val interaction: Interaction = InteractionImpl(ydwk, json, json["id"].asLong())
        when (interaction.type) {
            InteractionType.APPLICATION_COMMAND -> {
                ydwk.emitEvent(
                    io.github.ydwk.ydwk.evm.event.events.interaction.SlashCommandEvent(
                        ydwk, interaction.slashCommand!!))
            }
            InteractionType.MESSAGE_COMPONENT -> {
                ydwk.emitEvent(
                    io.github.ydwk.ydwk.evm.event.events.interaction.MessageComponentEvent(
                        ydwk, interaction.messageData!!))
            }
            InteractionType.APPLICATION_COMMAND_AUTOCOMPLETE -> {
                ydwk.emitEvent(
                    io.github.ydwk.ydwk.evm.event.events.interaction.AutoCompleteSlashCommandEvent(
                        ydwk, interaction))
            }
            InteractionType.MODAL_SUBMIT -> {
                ydwk.emitEvent(
                    io.github.ydwk.ydwk.evm.event.events.interaction.ModelEvent(ydwk, interaction))
            }
            InteractionType.PING -> {
                ydwk.emitEvent(
                    io.github.ydwk.ydwk.evm.event.events.interaction.PingEvent(ydwk, interaction))
            }
            InteractionType.UNKNOWN -> {
                ydwk.logger.warn("Unknown interaction type: ${interaction.type}")
            }
        }
    }
}
