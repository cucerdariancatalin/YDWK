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
package io.github.ydwk.ydwk.evm.handler.handlers.user

import com.fasterxml.jackson.databind.JsonNode
import io.github.ydwk.ydwk.cache.CacheIds
import io.github.ydwk.ydwk.entities.User
import io.github.ydwk.ydwk.evm.handler.Handler
import io.github.ydwk.ydwk.impl.YDWKImpl
import io.github.ydwk.ydwk.impl.entities.UserImpl
import java.awt.Color
import java.util.*

class UserUpdateHandler(ydwk: YDWKImpl, json: JsonNode) : Handler(ydwk, json) {

    override fun start() {
        val userJson: JsonNode = json

        val userCache = ydwk.cache[userJson.get("id").asText(), CacheIds.GUILD]

        if (userCache == null) {
            ydwk.logger.warn(
                "UserUpdateHandler: User with id ${userJson.get("id").asLong()} not found in cache, will add it")
            val user = UserImpl(json, json.get("id").asLong(), ydwk)
            ydwk.cache[user.id, user] = CacheIds.USER
            return
        }

        val user: User = userCache as User

        val oldName = user.name
        val newName = userJson.get("username").asText()
        if (!Objects.deepEquals(oldName, newName)) {
            user.name = newName
        }

        val oldDiscriminator = user.discriminator
        val newDiscriminator = userJson.get("discriminator").asText()
        if (!Objects.deepEquals(oldDiscriminator, newDiscriminator)) {
            user.discriminator = newDiscriminator
        }

        val oldAvatar = user.avatar
        val newAvatar = userJson.get("avatar").asText()
        if (!Objects.deepEquals(oldAvatar, newAvatar)) {
            user.avatar = newAvatar
        }

        val oldSystem = user.system
        val newSystem = userJson.get("system")
        when {
            oldSystem == null && newSystem != null -> user.system = newSystem.asBoolean()
            oldSystem != null && newSystem != null ->
                if (!Objects.deepEquals(oldSystem, newSystem.asBoolean())) {
                    user.system = newSystem.asBoolean()
                }
            else -> user.system = null
        }

        val oldMfaEnabled = user.mfaEnabled
        val newMfaEnabled = userJson.get("mfa_enabled")
        when {
            oldMfaEnabled == null && newMfaEnabled != null ->
                user.mfaEnabled = newMfaEnabled.asBoolean()
            oldMfaEnabled != null && newMfaEnabled != null ->
                if (!Objects.deepEquals(oldMfaEnabled, newMfaEnabled)) {
                    user.mfaEnabled = newMfaEnabled.asBoolean()
                }
            else -> user.mfaEnabled = null
        }

        val oldBanner = user.banner
        val newBanner = userJson.get("banner").asText()
        when {
            oldBanner == null && newBanner != null -> user.banner = newBanner
            oldBanner != null && newBanner != null ->
                if (!Objects.deepEquals(oldBanner, newBanner)) {
                    user.banner = newBanner
                }
            else -> user.banner = null
        }

        val oldAccentColor = user.accentColor
        val newAccentColor = userJson.get("accent_color")
        when {
            oldAccentColor == null && newAccentColor != null ->
                user.accentColor = Color(newAccentColor.asInt())
            oldAccentColor != null && newAccentColor != null ->
                if (!Objects.deepEquals(oldAccentColor, newAccentColor)) {
                    user.accentColor = Color(newAccentColor.asInt())
                }
            else -> user.accentColor = null
        }

        val oldLocale = user.banner
        val newLocale = userJson.get("locale").asText()
        when {
            oldLocale == null && newLocale != null -> user.locale = newLocale
            oldLocale != null && newLocale != null ->
                if (!Objects.deepEquals(oldLocale, newLocale)) {
                    user.locale = newLocale
                }
            else -> user.locale = null
        }

        val oldVerified = user.verified
        val newVerified = userJson.get("verified")
        when {
            oldVerified == null && newVerified != null -> user.verified = newVerified.asBoolean()
            oldVerified != null && newVerified != null ->
                if (!Objects.deepEquals(oldVerified, newVerified)) {
                    user.verified = newVerified.asBoolean()
                }
            else -> user.verified = null
        }

        val oldFlags = user.flags
        val newFlags = userJson.get("flags")
        when {
            oldFlags == null && newFlags != null -> user.flags = newFlags.asInt()
            oldFlags != null && newFlags != null ->
                if (!Objects.deepEquals(oldFlags, newFlags)) {
                    user.flags = newFlags.asInt()
                }
            else -> user.flags = null
        }
    }
}
