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
package io.github.ydwk.ydwk.impl.entities.message

import com.fasterxml.jackson.databind.JsonNode
import io.github.ydwk.ydwk.YDWK
import io.github.ydwk.ydwk.entities.message.Embed
import io.github.ydwk.ydwk.entities.message.embed.*
import io.github.ydwk.ydwk.impl.entities.message.embed.*
import java.awt.Color
import java.net.URL

class EmbedImpl(override val ydwk: YDWK, override val json: JsonNode) : Embed {

    override val title: String?
        get() = if (json.hasNonNull("title")) json["title"].asText() else null

    override val type: EmbedType?
        get() = if (json.hasNonNull("type")) EmbedType.from(json["type"].asText()) else null

    override val description: String?
        get() = if (json.hasNonNull("description")) json["description"].asText() else null

    override val url: URL?
        get() = if (json.hasNonNull("url")) URL(json["url"].asText()) else null

    override val timestamp: String?
        get() = if (json.hasNonNull("timestamp")) json["timestamp"].asText() else null

    override val color: Color?
        get() = if (json.hasNonNull("color")) Color(json["color"].asInt()) else null

    override val footer: Footer?
        get() = if (json.hasNonNull("footer")) FooterImpl(ydwk, json["footer"]) else null

    override val image: Image?
        get() = if (json.hasNonNull("image")) ImageImpl(ydwk, json["image"]) else null

    override val thumbnail: Thumbnail?
        get() = if (json.hasNonNull("thumbnail")) ThumbnailImpl(ydwk, json["thumbnail"]) else null

    override val video: Video?
        get() = if (json.hasNonNull("video")) VideoImpl(ydwk, json["video"]) else null

    override val provider: Provider?
        get() = if (json.hasNonNull("provider")) ProviderImpl(ydwk, json["provider"]) else null

    override val author: Author?
        get() = if (json.hasNonNull("author")) AuthorImpl(ydwk, json["author"]) else null

    override val fields: List<Field>
        get() =
            if (json.hasNonNull("fields")) json["fields"].map { FieldImpl(ydwk, it) }
            else emptyList()
}
