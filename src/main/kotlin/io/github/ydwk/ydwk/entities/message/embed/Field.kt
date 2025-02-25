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
package io.github.ydwk.ydwk.entities.message.embed

import io.github.ydwk.ydwk.entities.util.GenericEntity

interface Field : GenericEntity {
    /**
     * Gets the name of this field.
     *
     * @return The name of this field.
     */
    val name: String

    /**
     * Gets the value of this field.
     *
     * @return The value of this field.
     */
    val value: String

    /**
     * Gets weather this field is inline.
     *
     * @return True if this field is inline, false otherwise.
     */
    val inline: Boolean?
}
