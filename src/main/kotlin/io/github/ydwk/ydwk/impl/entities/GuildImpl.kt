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
import io.github.ydwk.ydwk.entities.Guild
import io.github.ydwk.ydwk.entities.Sticker
import io.github.ydwk.ydwk.entities.channel.GuildChannel
import io.github.ydwk.ydwk.entities.channel.guild.GenericGuildChannel
import io.github.ydwk.ydwk.entities.channel.guild.GuildCategory
import io.github.ydwk.ydwk.entities.channel.guild.message.text.GuildTextChannel
import io.github.ydwk.ydwk.entities.channel.guild.vc.GuildVoiceChannel
import io.github.ydwk.ydwk.entities.guild.Ban
import io.github.ydwk.ydwk.entities.guild.Member
import io.github.ydwk.ydwk.entities.guild.Role
import io.github.ydwk.ydwk.entities.guild.WelcomeScreen
import io.github.ydwk.ydwk.entities.guild.enums.*
import io.github.ydwk.ydwk.impl.entities.guild.BanImpl
import io.github.ydwk.ydwk.impl.entities.guild.RoleImpl
import io.github.ydwk.ydwk.impl.entities.guild.WelcomeScreenImpl
import io.github.ydwk.ydwk.rest.EndPoint
import io.github.ydwk.ydwk.util.GetterSnowFlake
import java.util.concurrent.CompletableFuture

class GuildImpl(override val ydwk: YDWK, override val json: JsonNode, override val idAsLong: Long) :
    Guild {
    override var icon: String? = if (json.hasNonNull("icon")) json["icon"].asText() else null

    override var splash: String? = if (json.hasNonNull("splash")) json["splash"].asText() else null

    override var discoverySplash: String? =
        if (json.hasNonNull("discovery_splash")) json["discovery_splash"].asText() else null

    override var isOwner: Boolean? =
        if (json.hasNonNull("owner")) json["owner"].asBoolean() else null

    override var ownerId: GetterSnowFlake = GetterSnowFlake.of(json["owner_id"].asLong())

    override var permissions: String? =
        if (json.hasNonNull("permissions")) json["permissions"].asText() else null

    override var afkChannelId: GetterSnowFlake? =
        if (json.hasNonNull("afk_channel_id")) GetterSnowFlake.of(json["afk_channel_id"].asLong())
        else null

    override var afkTimeout: Int = json["afk_timeout"].asInt()

    override var isWidgetEnabled: Boolean? =
        if (json.hasNonNull("widget_enabled")) json["widget_enabled"].asBoolean() else null

    override var widgetChannelId: GetterSnowFlake? =
        if (json.hasNonNull("widget_channel_id"))
            GetterSnowFlake.of(json["widget_channel_id"].asLong())
        else null

    override var verificationLevel: VerificationLevel =
        VerificationLevel.fromLevel(json["verification_level"].asInt())

    override var defaultMessageNotificationsLevel: MessageNotificationLevel =
        MessageNotificationLevel.fromValue(json["default_message_notifications"].asInt())

    override var explicitContentFilterLevel: ExplicitContentFilterLevel =
        ExplicitContentFilterLevel.fromValue(json["explicit_content_filter"].asInt())

    override var roles: List<Role> = json["roles"].map { RoleImpl(ydwk, it, it["id"].asLong()) }

    override var emojis: List<Emoji> = json["emojis"].map { EmojiImpl(ydwk, it) }

    override var features: Set<GuildFeature> =
        json["features"].map { GuildFeature.fromString(it.asText()) }.toSet()

    override var mfaLevel: MFALevel = MFALevel.fromValue(json["mfa_level"].asInt())

    override var applicationId: GetterSnowFlake? =
        if (json.hasNonNull("application_id")) GetterSnowFlake.of(json["application_id"].asLong())
        else null

    override var systemChannelId: GetterSnowFlake? =
        if (json.hasNonNull("system_channel_id"))
            GetterSnowFlake.of(json["system_channel_id"].asLong())
        else null

    override var systemChannelFlags: SystemChannelFlag =
        SystemChannelFlag.fromValue(json["system_channel_flags"].asInt())

    override var rulesChannelId: GetterSnowFlake? =
        if (json.hasNonNull("rules_channel_id"))
            GetterSnowFlake.of(json["rules_channel_id"].asLong())
        else null

    override var maxPresences: Int? =
        if (json.hasNonNull("max_presences")) json["max_presences"].asInt() else null

    override var maxMembers: Int = json["max_members"].asInt()

    override var vanityUrlCode: String? =
        if (json.hasNonNull("vanity_url_code")) json["vanity_url_code"].asText() else null

    override var description: String? =
        if (json.hasNonNull("description")) json["description"].asText() else null

    override var banner: String? = if (json.hasNonNull("banner")) json["banner"].asText() else null

    override var premiumTier: PremiumTier = PremiumTier.fromValue(json["premium_tier"].asInt())

    override var premiumSubscriptionCount: Int = json["premium_subscription_count"].asInt()

    override var preferredLocale: String = json["preferred_locale"].asText()

    override var publicUpdatesChannelId: GetterSnowFlake? =
        if (json.hasNonNull("public_updates_channel_id"))
            GetterSnowFlake.of(json["public_updates_channel_id"].asLong())
        else null

    override var maxVideoChannelUsers: Int? =
        if (json.hasNonNull("max_video_channel_users")) json["max_video_channel_users"].asInt()
        else null

    override var approximateMemberCount: Int? =
        if (json.hasNonNull("approximate_member_count")) json["approximate_member_count"].asInt()
        else null

    override var approximatePresenceCount: Int? =
        if (json.hasNonNull("approximate_presence_count"))
            json["approximate_presence_count"].asInt()
        else null

    override var welcomeScreen: WelcomeScreen? =
        if (json.hasNonNull("welcome_screen")) WelcomeScreenImpl(ydwk, json["welcome_screen"])
        else null

    override var nsfwLevel: NSFWLeveL = NSFWLeveL.fromValue(json["nsfw_level"].asInt())

    override var stickers: List<Sticker> =
        json["stickers"].map { StickerImpl(ydwk, it, it["id"].asLong()) }

    override var isBoostProgressBarEnabled: Boolean =
        json["premium_progress_bar_enabled"].asBoolean()

    override val requestBans: CompletableFuture<List<Ban>>
        get() {
            return ydwk.restApiManager.get(EndPoint.GuildEndpoint.GET_BANS, id).execute { it ->
                val jsonBody = it.jsonBody
                jsonBody?.map { BanImpl(ydwk, it) }
                    ?: throw IllegalStateException("Response body is null")
            }
        }

    override val botAsMember: Member
        get() =
            if (ydwk.bot?.let { ydwk.getMemberById(this.id, it.id) } == null) {
                throw IllegalStateException("Bot is not a member of this guild")
            } else {
                ydwk.getMemberById(this.id, ydwk.bot!!.id)!!
            }

    override fun getRoleById(roleId: Long): Role? {
        return if (roles.any { it.idAsLong == roleId }) {
            roles.first { it.idAsLong == roleId }
        } else {
            null
        }
    }

    override val getUnorderedChannels: List<GuildChannel>
        get() = ydwk.guildChannels.filter { it.guild.id == id }

    override val getChannels: List<GenericGuildChannel>
        get() = getUnorderedChannels.filterIsInstance<GenericGuildChannel>()

    override val getCategories: List<GuildCategory>
        get() = getUnorderedChannels.filterIsInstance<GuildCategory>()

    override val getTextChannels: List<GuildTextChannel>
        get() = getUnorderedChannels.filterIsInstance<GuildTextChannel>()

    override val getVoiceChannels: List<GuildVoiceChannel>
        get() = getUnorderedChannels.filterIsInstance<GuildVoiceChannel>()

    override fun getChannelById(channelId: Long): GuildChannel? {
        return getUnorderedChannels.firstOrNull { it.idAsLong == channelId }
    }

    override var name: String = json["name"].asText()
}
