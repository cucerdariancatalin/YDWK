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
package io.github.ydwk.ydwk.impl.entities

import com.fasterxml.jackson.databind.JsonNode
import io.github.ydwk.ydwk.YDWK
import io.github.ydwk.ydwk.entities.Emoji
import io.github.ydwk.ydwk.entities.User
import io.github.ydwk.ydwk.entities.guild.Role
import io.github.ydwk.ydwk.impl.entities.guild.RoleImpl

class EmojiImpl(override val ydwk: YDWK, override val json: JsonNode) : Emoji {
    override val idLong: Long?
        get() = if (json.has("id")) json["id"].asLong() else null

    override var roles: List<Role> =
        if (json.has("roles")) json["roles"].map { RoleImpl(ydwk, it, it["id"].asLong()) }
        else emptyList()

    override var user: User? =
        if (json.has("user")) UserImpl(json["user"], json["user"]["id"].asLong(), ydwk) else null

    override var requireColons: Boolean =
        if (json.has("require_colons")) json["require_colons"].asBoolean() else false

    override var isManaged: Boolean =
        if (json.has("managed")) json["managed"].asBoolean() else false

    override var isAnimated: Boolean =
        if (json.has("animated")) json["animated"].asBoolean() else false

    override var isAvailable: Boolean =
        if (json.has("available")) json["available"].asBoolean() else false

    override var name: String = if (json.has("name")) json["name"].asText() else ""
}
