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

interface GenericGuildChannel : GuildChannel, Comparable<GenericGuildChannel> {
    /**
     * Weather the channel is voice channel.
     *
     * @return true if the channel is voice channel.
     */
    val isVoiceChannel: Boolean

    /**
     * Weather the channel is a text channel.
     *
     * @return true if the channel is a text channel.
     */
    val isTextChannel: Boolean

    /**
     * Weather the channel is a category channel.
     *
     * @return true if the channel is a category channel.
     */
    val isCategory: Boolean

    /**
     * Gets the channel as Guild Category.
     *
     * @return the channel as Guild Category.
     */
    fun asGuildCategory(): GuildCategory?

    /**
     * Gets the channel as a generic guild text channel.
     *
     * @return the channel as a generic guild text channel.
     */
    fun asGenericGuildTextChannel(): GenericGuildTextChannel

    /**
     * Gets the channel as a generic guild voice channel.
     *
     * @return the channel as a generic guild voice channel.
     */
    fun asGenericGuildVoiceChannel(): GenericGuildVoiceChannel

    override fun compareTo(other: GenericGuildChannel): Int {
        if (guild != other.guild) {
            throw IllegalArgumentException("Cannot compare channels from different guilds")
        }
        return position.compareTo(other.position)
    }
}
