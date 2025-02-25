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
package io.github.ydwk.ydwk.impl.entities.audit

import com.fasterxml.jackson.databind.JsonNode
import io.github.ydwk.ydwk.YDWK
import io.github.ydwk.ydwk.entities.audit.AuditLogChange

class AuditLogChangeImpl(override val ydwk: YDWK, override val json: JsonNode) : AuditLogChange {
    override val newValue: Any?
        get() = if (json.has("new_value")) checkType(json["new_value"]) else null

    override val oldValue: Any?
        get() = if (json.has("old_value")) checkType(json["old_value"]) else null

    private fun checkType(node: JsonNode): Any? {
        return when {
            node.isTextual -> node.asText()
            node.isInt -> node.asInt()
            node.isBoolean -> node.asBoolean()
            node.isLong -> node.asLong()
            node.isDouble or node.isFloat -> node.asDouble()
            else -> null
        }
    }

    override val key: String
        get() = json["key"].asText()
}
