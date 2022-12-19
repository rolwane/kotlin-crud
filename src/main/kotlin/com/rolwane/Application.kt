package com.rolwane

import io.ktor.server.application.*
import com.rolwane.plugins.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureSerialization()
    configureRouting()
    configureStatusPages()
}
