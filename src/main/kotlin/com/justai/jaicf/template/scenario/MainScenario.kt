package com.justai.jaicf.template.scenario

import com.justai.jaicf.builder.Scenario
import com.justai.jaicf.channel.telegram.telegram
import com.justai.jaicf.model.scenario.Scenario

val MainScenario = Scenario {
    append(MoodScenario)

    state("main") {
        activators {
            intent("greet")
            regex("/start")
        }

        action {
            reactions.run {
                sayRandom("Hi there!", "Hello!", "Good day!")
                telegram?.go("/mood")
            }
        }
    }

    state("bye") {
        activators {
            intent("goodbye")
        }

        action {
            reactions.sayRandom("Bye bye!", "See you latter!")
        }
    }

    state("smalltalk") {
        activators {
            intent("bot_challenge")
        }

        action {
            reactions.sayRandom("Yep! I'm a bot.", "Yes, I am.")
        }
    }

    fallback {
        reactions.run {
            sayRandom("Sorry, I didn't get that...", "Looks like it's something new for me...")
            say("Could you repeat please?")
        }
    }
}