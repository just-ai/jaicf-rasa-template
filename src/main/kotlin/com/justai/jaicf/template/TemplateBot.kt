package com.justai.jaicf.template

import com.justai.jaicf.BotEngine
import com.justai.jaicf.activator.catchall.CatchAllActivator
import com.justai.jaicf.activator.rasa.RasaIntentActivator
import com.justai.jaicf.activator.rasa.api.RasaApi
import com.justai.jaicf.activator.regex.RegexActivator
import com.justai.jaicf.context.manager.InMemoryBotContextManager
import com.justai.jaicf.context.manager.mongo.MongoBotContextManager
import com.justai.jaicf.template.scenario.MainScenario
import com.mongodb.client.MongoClients

private val rasaApi = RasaApi(System.getenv("RASA_URL") ?: "http://localhost:5005")

private val contextManager = System.getenv("MONGODB_URI")?.let { url ->
    val client = MongoClients.create(url)
    MongoBotContextManager(client.getDatabase("jaicf").getCollection("contexts"))
} ?: InMemoryBotContextManager

val templateBot = BotEngine(
    scenario = MainScenario,
    defaultContextManager = contextManager,
    activators = arrayOf(
        RasaIntentActivator.Factory(rasaApi),
        RegexActivator,
        CatchAllActivator
    )
)