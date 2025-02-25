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
package io.github.ydwk.ydwk.interaction

import io.github.ydwk.ydwk.entities.Guild
import io.github.ydwk.ydwk.entities.Message
import io.github.ydwk.ydwk.entities.User
import io.github.ydwk.ydwk.entities.channel.guild.GenericGuildTextChannel
import io.github.ydwk.ydwk.entities.guild.Member
import io.github.ydwk.ydwk.entities.util.GenericEntity
import io.github.ydwk.ydwk.interaction.application.SlashCommand
import io.github.ydwk.ydwk.interaction.message.MessageComponentData
import io.github.ydwk.ydwk.interaction.sub.GenericCommandData
import io.github.ydwk.ydwk.interaction.sub.InteractionType
import io.github.ydwk.ydwk.util.GetterSnowFlake
import io.github.ydwk.ydwk.util.SnowFlake

interface Interaction : SnowFlake, GenericEntity {
    /**
     * Gets the Id of the application that this interaction is for.
     *
     * @return The Id of the application that this interaction is for.
     */
    val applicationId: GetterSnowFlake

    /**
     * Gets the type of this interaction.
     *
     * @return The type of this interaction.
     */
    val type: InteractionType

    /**
     * Gets the data of this interaction.
     *
     * @return The data of this interaction.
     */
    val data: GenericCommandData?

    /**
     * Gets the message command data of this interaction.
     *
     * @return The message command data of this interaction.
     */
    val messageData
        get() = data as? MessageComponentData

    /**
     * Gets the application command data of this interaction
     *
     * @return The application command data of this interaction
     */
    val slashCommand
        get() = data as? SlashCommand

    /**
     * Gets the guild that this interaction is for.
     *
     * @return The guild that this interaction is for.
     */
    val guild: Guild?

    /**
     * Gets the channel that this interaction is for.
     *
     * @return The channel that this interaction is for.
     */
    val channel: GenericGuildTextChannel?

    /**
     * Gets the member who invoked this interaction.
     *
     * @return The member who invoked this interaction.
     */
    val member: Member?

    /**
     * Gets the user who invoked this interaction.
     *
     * @return The user who invoked this interaction.
     */
    val user: User?

    /**
     * Gets the token of this interaction.
     *
     * @return The token of this interaction.
     */
    val token: String

    /**
     * Gets the version of this interaction.
     *
     * @return The version of this interaction.
     */
    val version: Int

    /**
     * Gets the message of this interaction.
     *
     * @return The message of this interaction.
     */
    val message: Message?

    /**
     * Gets bitwise set of permissions the app or bot has within the channel the interaction was
     * sent from
     *
     * @return bitwise set of permissions the app or bot has within the channel the interaction was
     * sent from
     */
    val permissions: Long?

    /**
     * Gets the selected language of the invoking user
     *
     * @return the selected language of the invoking user
     */
    val locale: String?

    /** Gets the Guild's preferred locale, if invoked in a guild */
    val guildLocale: String?
}
