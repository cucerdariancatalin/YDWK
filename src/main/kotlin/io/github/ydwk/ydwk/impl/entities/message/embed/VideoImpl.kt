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
package io.github.ydwk.ydwk.impl.entities.message.embed

import com.fasterxml.jackson.databind.JsonNode
import io.github.ydwk.ydwk.YDWK
import io.github.ydwk.ydwk.entities.message.embed.Video
import java.net.URL

class VideoImpl(override val ydwk: YDWK, override val json: JsonNode) : Video {

    override val url: URL?
        get() = if (json.has("url")) URL(json["url"].asText()) else null

    override val proxyUrl: String?
        get() = if (json.has("proxy_url")) json["proxy_url"].asText() else null

    override val height: Int?
        get() = if (json.has("height")) json["height"].asInt() else null

    override val width: Int?
        get() = if (json.has("width")) json["width"].asInt() else null
}
