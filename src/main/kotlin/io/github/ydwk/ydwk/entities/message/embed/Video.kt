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
import java.net.URL

interface Video : GenericEntity {
    /**
     * Gets the url of this video.
     *
     * @return The url of this video.
     */
    val url: URL?

    /**
     * Gets the proxy url of this video.
     *
     * @return The proxy url of this video.
     */
    val proxyUrl: String?

    /**
     * Gets the height of this video.
     *
     * @return The height of this video.
     */
    val height: Int?

    /**
     * Gets the width of this video.
     *
     * @return The width of this video.
     */
    val width: Int?
}
