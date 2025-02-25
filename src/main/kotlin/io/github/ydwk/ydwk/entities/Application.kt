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
package io.github.ydwk.ydwk.entities

import io.github.ydwk.ydwk.entities.util.GenericEntity
import io.github.ydwk.ydwk.util.GetterSnowFlake
import io.github.ydwk.ydwk.util.NameAbleEntity
import io.github.ydwk.ydwk.util.SnowFlake
import java.net.URL

interface Application : SnowFlake, NameAbleEntity, GenericEntity {
    /** The icon hash of the application. */
    var icon: String?

    /** The description of the application. */
    var description: String

    /** An array of rpc origin urls, if rpc is enabled. */
    var rpcOrigins: Array<String>?

    /** If the bot can only be added by the bot owner. */
    var botPublic: Boolean

    /** If the bot will only join upon completion of the full oauth2 code grant flow */
    var botRequireCodeGrant: Boolean

    /** The bots terms of service. */
    var botTermsOfService: URL?

    /** The bots privacy policy. */
    var botPrivacyPolicy: URL?

    /** The owner of the bot. */
    var botOwner: User?

    /** The hex encoded key for verification in interactions and the GameSDK's GetTicket */
    var verifyKey: String?

    /** Getsd the guild this application is for. */
    var guild: Guild?

    /** The game sdk id of the application. */
    var gameSdkId: GetterSnowFlake?

    /** The url of the slug for the application. */
    var slug: String?

    /** The cover image hash. */
    var coverImage: String?

    /** The application's public flags. */
    var flags: Int?

    /** The application's tags. */
    var tags: Array<String>?
}
