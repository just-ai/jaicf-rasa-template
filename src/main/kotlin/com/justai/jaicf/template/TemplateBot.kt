package com.justai.jaicf.template

import com.justai.jaicf.BotEngine
import com.justai.jaicf.activator.catchall.CatchAllActivator
import com.justai.jaicf.activator.rasa.RasaIntentActivator
import com.justai.jaicf.activator.rasa.api.RasaApi
import com.justai.jaicf.activator.regex.RegexActivator
import com.justai.jaicf.context.manager.InMemoryBotContextManager
import com.justai.jaicf.context.manager.mongo.MongoBotContextManager
import com.justai.jaicf.template.scenario.MainScenario
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI

private val rasaApi = RasaApi(System.getenv("RASA_URL") ?: "http://localhost:5005")

private val contextManager = System.getenv("MONGODB_URI")?.let { url ->
    val uri = MongoClientURI(url)
    val client = MongoClient(uri)
    MongoBotContextManager(client.getDatabase(uri.database!!).getCollection("contexts"))

} ?: InMemoryBotContextManager

val templateBot = BotEngine(
    model = MainScenario.model,
    contextManager = contextManager,
    activators = arrayOf(
        RasaIntentActivator.Factory(rasaApi),
        RegexActivator,
        CatchAllActivator
    )
)