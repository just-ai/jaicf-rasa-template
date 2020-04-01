package com.justai.jaicf.template.channel

import com.justai.jaicf.channel.telegram.TelegramChannel
import com.justai.jaicf.template.templateBot

fun main() {
    TelegramChannel(templateBot, System.getenv("TELEGRAM_TOKEN")).run()
}