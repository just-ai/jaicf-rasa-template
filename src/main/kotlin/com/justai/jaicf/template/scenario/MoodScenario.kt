package com.justai.jaicf.template.scenario

import com.justai.jaicf.channel.telegram.telegram
import com.justai.jaicf.model.scenario.Scenario

object MoodScenario: Scenario() {
    init {
        state("mood") {
            action {
                reactions.telegram?.say(
                    text = random("How are you?", "How are you doing?"),
                    inlineButtons = listOf("Good", "Bad")
                )
            }

            state("good") {
                activators {
                    intent("mood_great")
                }

                action {
                    reactions.say("Great! Have a nice day!")
                }
            }

            state("bad") {
                activators {
                    intent("mood_unhappy")
                }

                action {
                    reactions.run {
                        sayRandom("Oh no!", "Sad..")
                        image(RandomApi.catImage())
                        telegram?.say(
                            text = "Did this funny cat help you?",
                            inlineButtons = listOf("Yep", "Nope")
                        )
                    }
                }

                state("yes") {
                    activators {
                        intent("affirm")
                    }

                    action {
                        reactions.say("Great! Have a nice day!")
                    }
                }

                state("no") {
                    activators {
                        intent("deny")
                    }

                    action {
                        reactions.go("../")
                    }
                }
            }
        }
    }
}