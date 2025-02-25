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
package io.github.ydwk.ydwk.entities.guild.enums

enum class VerificationLevel(val level: Int) {
    /** Unrestricted */
    NONE(0),

    /** Must have a verified email on their account */
    LOW(1),

    /** Must be registered on Discord for longer than 5 minutes */
    MEDIUM(2),

    /** Must be a member of the server for longer than 10 minutes */
    HIGH(3),

    /** Must have a verified phone number */
    VERY_HIGH(4),

    /** An unknown verification level */
    UNKNOWN(-1);

    companion object {
        /** Gets the [VerificationLevel] by the provided [level]. */
        fun fromLevel(level: Int): VerificationLevel {
            return values().firstOrNull { it.level == level } ?: UNKNOWN
        }
    }
}
