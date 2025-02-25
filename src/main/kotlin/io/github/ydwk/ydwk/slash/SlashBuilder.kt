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
package io.github.ydwk.ydwk.slash

import javax.annotation.CheckReturnValue

interface SlashBuilder {

    /**
     * Adds a slash command to the builder
     *
     * @param name The name of the slash command
     * @param description The description of the slash command
     * @return The [SlashBuilder] object that was added
     */
    @CheckReturnValue fun addSlashCommand(name: String, description: String): SlashBuilder

    /**
     * Adds a new Slash Command to the builder
     *
     * @param slash The Slash Command to add
     */
    @CheckReturnValue fun addSlashCommand(slash: Slash): SlashBuilder

    /**
     * Used a list of Slash Commands to the builder
     *
     * @param slashes The list of Slash Commands to add
     */
    @CheckReturnValue fun addSlashCommands(slashes: List<Slash>): SlashBuilder

    /**
     * Used a list of Slash Commands to the builder
     *
     * @param slashes The list of Slash Commands to add
     */
    @CheckReturnValue fun addSlashCommands(vararg slashes: Slash): SlashBuilder

    /** Gets all the Slash Commands in the builder */
    @CheckReturnValue fun getSlashCommands(): List<Slash>

    /**
     * Removes a Slash Command from the builder
     *
     * @param slash The Slash Command to remove
     */
    @CheckReturnValue fun removeSlashCommand(slash: Slash): SlashBuilder

    /**
     * Replies a List of Slash Commands from the builder
     *
     * @param slashes The List of Slash Commands to remove
     */
    @CheckReturnValue fun removeSlashCommands(slashes: List<Slash>): SlashBuilder

    /**
     * Replies a List of Slash Commands from the builder
     *
     * @param slashes The List of Slash Commands to remove
     */
    @CheckReturnValue fun removeSlashCommands(vararg slashes: Slash): SlashBuilder

    /** Removes all Slash Commands from the builder */
    @CheckReturnValue fun removeAllSlashCommands(): SlashBuilder

    /** Builds the Slash Commands */
    fun build()
}
