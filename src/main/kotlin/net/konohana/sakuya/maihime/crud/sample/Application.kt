package net.konohana.sakuya.maihime.crud.sample

import io.ktor.server.application.Application
import net.konohana.sakuya.maihime.crud.sample.db.initArisuDB
import net.konohana.sakuya.maihime.crud.sample.plugins.configureHTTP
import net.konohana.sakuya.maihime.crud.sample.plugins.configureRouting
import net.konohana.sakuya.maihime.crud.sample.plugins.configureSerialization


fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    val url = environment.config.property("ktor.arisudb.uri").getString()
    val username = environment.config.property("ktor.arisudb.username").getString()
    val password = environment.config.property("ktor.arisudb.password").getString()
    initArisuDB(url, username, password)
    configureSerialization()
    configureHTTP()
    configureRouting()
}
