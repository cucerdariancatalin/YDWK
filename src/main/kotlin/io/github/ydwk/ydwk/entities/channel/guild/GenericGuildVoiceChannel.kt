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
package io.github.ydwk.ydwk.entities.channel.guild

import io.github.ydwk.ydwk.entities.channel.GuildChannel
import io.github.ydwk.ydwk.entities.channel.VoiceChannel
import io.github.ydwk.ydwk.entities.channel.guild.vc.GuildStageChannel
import io.github.ydwk.ydwk.entities.channel.guild.vc.GuildVoiceChannel

interface GenericGuildVoiceChannel : VoiceChannel, GuildChannel {
    /**
     * Gets the channel as Guild Voice Channel.
     *
     * @return the channel as Guild Voice Channel.
     */
    fun asGuildVoiceChannel(): GuildVoiceChannel?

    /**
     * Gets the channel as a guild stage channel.
     *
     * @return the channel as a stage channel.
     */
    fun asStageChannel(): GuildStageChannel?
}
