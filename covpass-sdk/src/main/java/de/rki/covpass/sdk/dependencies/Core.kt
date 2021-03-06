/*
 * (C) Copyright IBM Deutschland GmbH 2021
 * (C) Copyright IBM Corp. 2021
 */

package de.rki.covpass.sdk.dependencies

import de.rki.covpass.sdk.utils.serialization.InstantSerializer
import de.rki.covpass.sdk.utils.serialization.LocalDateSerializer
import de.rki.covpass.sdk.utils.serialization.ZonedDateTimeSerializer
import kotlinx.serialization.cbor.Cbor
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual

private val module = SerializersModule {
    contextual(InstantSerializer)
    contextual(LocalDateSerializer)
    contextual(ZonedDateTimeSerializer)
}

public val defaultCbor: Cbor = Cbor {
    ignoreUnknownKeys = true
    serializersModule = module
    encodeDefaults = true
}

public val defaultJson: Json = Json {
    ignoreUnknownKeys = true
    serializersModule = module
    encodeDefaults = true
}
