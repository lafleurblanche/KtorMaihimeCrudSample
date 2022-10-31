package net.konohana.sakuya.maihime.crud.sample.controller

import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus

fun Route.maihimeDateTimeSampleController() {
    route("maihime") {
        route("datetime") {
            route("today") {
                get {
                    val now = Clock.System.now()
                    call.respond(mapOf("today" to now.toString()))
                }
            }
            route("tomorrow") {
                get {
                    val now = Clock.System.now()
                    val systemTZ = TimeZone.currentSystemDefault()
                    val tomorrow = now.plus(1, DateTimeUnit.DAY, systemTZ)
                    call.respond(mapOf("tomorrow" to tomorrow.toString()))
                }
            }
        }
    }
}
