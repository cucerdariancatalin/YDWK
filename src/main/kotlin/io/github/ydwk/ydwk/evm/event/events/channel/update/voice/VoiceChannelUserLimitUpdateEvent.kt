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
package io.github.ydwk.ydwk.evm.event.events.channel.update.voice

import io.github.ydwk.ydwk.YDWK
import io.github.ydwk.ydwk.entities.channel.guild.GenericGuildVoiceChannel
import io.github.ydwk.ydwk.evm.event.events.channel.GenericChannelUpdateEvent

/** Fired when a voice/stage channel's user rate limit is updated. */
data class VoiceChannelUserLimitUpdateEvent(
    override val ydwk: YDWK,
    override val entity: GenericGuildVoiceChannel,
    val oldUserLimit: Int,
    val newUserLimit: Int
) : GenericChannelUpdateEvent<Int>(ydwk, entity, oldUserLimit, newUserLimit)
