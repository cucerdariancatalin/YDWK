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

interface Provider : GenericEntity {
    /**
     * Gets the name of this provider.
     *
     * @return The name of this provider.
     */
    val name: String?

    /**
     * Gets the url of this provider.
     *
     * @return The url of this provider.
     */
    val url: String?
}
