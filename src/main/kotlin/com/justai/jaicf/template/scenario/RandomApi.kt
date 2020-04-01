package com.justai.jaicf.template.scenario

import com.fasterxml.jackson.databind.node.ObjectNode
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.JacksonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get
import kotlinx.coroutines.runBlocking

object RandomApi {

    private val client = HttpClient(CIO) {
        expectSuccess = true

        install(JsonFeature) {
            serializer = JacksonSerializer()
        }
    }

    fun catImage() = runBlocking {
        client.get<ObjectNode>("https://some-random-api.ml/img/cat").get("link").asText()
    }
}