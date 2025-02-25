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
package io.github.ydwk.ydwk.interaction.application

import com.fasterxml.jackson.databind.JsonNode
import io.github.ydwk.ydwk.entities.util.GenericEntity
import io.github.ydwk.ydwk.slash.SlashOptionType

interface ApplicationCommandOption : GenericEntity {
    /**
     * Gets the name of the option.
     *
     * @return The name of the option.
     */
    var name: String

    /**
     * Gets the type of the option.
     *
     * @return The type of the option.
     */
    val type: SlashOptionType

    /**
     * Gets the value as Any.
     *
     * @return The value as Any.
     */
    val value: JsonNode

    /**
     * Gets the options of the option.
     *
     * @return The options of the option.
     */
    val options: List<ApplicationCommandOption>

    /**
     * Gets weather this option is the currently focused option for autocomplete.
     *
     * @return Weather this option is the currently focused option for autocomplete.
     */
    val focused: Boolean?
}
