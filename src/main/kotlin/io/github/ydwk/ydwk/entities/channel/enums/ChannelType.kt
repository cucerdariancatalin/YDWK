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
package io.github.ydwk.ydwk.entities.channel.enums

enum class ChannelType(private val id: Int) {
    /** A text channel within a guild. */
    TEXT(0),
    /** A direct message between users. */
    DM(1),
    /** A voice channel within a guild. */
    VOICE(2),
    /** A direct message between multiple users. */
    GROUP_DM(3),
    /** An organizational category that contains up to 50 channels. */
    CATEGORY(4),
    /** A channel that users can follow and crosspost into their own guild. */
    NEWS(5),
    /** A temporary sub-channel within a GUILD_ANNOUNCEMENT channel. */
    NEWS_THREAD(10),
    /** A temporary sub-channel within a GUILD_TEXT channel. */
    PUBLIC_THREAD(11),
    /**
     * A temporary sub-channel within a GUILD_TEXT channel that is only viewable by those invited
     * and those with the MANAGE_THREADS permission.
     */
    PRIVATE_THREAD(12),
    /** A voice channel for hosting events with an audience. */
    STAGE_VOICE(13),
    /** A channel in a hub containing the listed servers. */
    DIRECTORY(14),
    /** A channel that can only contain threads. */
    FORUM(15),
    /** An unknown channel type. */
    UNKNOWN(-1);

    companion object {
        /**
         * Get the channel type from the id.
         *
         * @param id the id
         * @return the channel type
         */
        fun fromId(id: Int): ChannelType {
            return values().firstOrNull { it.id == id } ?: UNKNOWN
        }
    }

    /**
     * Get the id of the channel type.
     *
     * @return the id
     */
    fun getId(): Int {
        return id
    }

    val isCategory: Boolean
        get() = this == CATEGORY

    val isGuildText: Boolean
        get() =
            this == TEXT ||
                this == NEWS ||
                this == NEWS_THREAD ||
                this == PUBLIC_THREAD ||
                this == PRIVATE_THREAD ||
                this == FORUM ||
                this == DIRECTORY

    val isVoice: Boolean
        get() = this == VOICE || this == STAGE_VOICE
}
