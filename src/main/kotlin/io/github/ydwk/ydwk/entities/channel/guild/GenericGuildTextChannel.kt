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
import io.github.ydwk.ydwk.entities.channel.TextChannel
import io.github.ydwk.ydwk.entities.channel.guild.forum.GuildForumChannel
import io.github.ydwk.ydwk.entities.channel.guild.message.news.GuildNewsChannel
import io.github.ydwk.ydwk.entities.channel.guild.message.text.GuildTextChannel

interface GenericGuildTextChannel : TextChannel, GuildChannel {
    /**
     * Gets the channel as Guild Text Channel.
     *
     * @return the channel as Guild Text Channel.
     */
    fun asGuildTextChannel(): GuildTextChannel?

    /**
     * Gets the channel as Guild News Channel.
     *
     * @return the channel as Guild News Channel.
     */
    fun asGuildNewsChannel(): GuildNewsChannel?

    /**
     * Gets the channel as Guild Forum Channel.
     *
     * @return the channel as Guild Forum Channel.
     */
    fun asGuildForumChannel(): GuildForumChannel?
}
