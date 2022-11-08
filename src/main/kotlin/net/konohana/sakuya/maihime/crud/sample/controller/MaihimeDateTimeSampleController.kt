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
import net.konohana.sakuya.maihime.crud.sample.utils.date.dateOfUseFormatter

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
            route("day-after-tomorrow") {
                get {
                    val now = Clock.System.now()
                    val systemTZ = TimeZone.currentSystemDefault()
                    val dayAfterTomorrow = now.plus(2, DateTimeUnit.DAY, systemTZ)
                    call.respond(mapOf("tomorrow" to dayAfterTomorrow.toString()))
                }
            }
            route("one-month") {
                get {
                    val now = Clock.System.now()
                    val systemTZ = TimeZone.currentSystemDefault()
                    val oneMonth = now.plus(1, DateTimeUnit.MONTH, systemTZ)
                    call.respond(mapOf("one-month" to oneMonth.toString()))
                }
            }
        }
        route("date") {
            route("today") {
                get {
                    val now = Clock.System.now()
                    val todayFix = dateOfUseFormatter(now.toString())
                    call.respond(mapOf("today" to todayFix))
                }
            }
            route("tomorrow") {
                get {
                    val now = Clock.System.now()
                    val systemTZ = TimeZone.currentSystemDefault()
                    val tomorrow = now.plus(1, DateTimeUnit.DAY, systemTZ)
                    val tomorrowFix = dateOfUseFormatter(tomorrow.toString())
                    call.respond(mapOf("tomorrow" to tomorrowFix))
                }
            }
            route("one-month") {
                get {
                    val now = Clock.System.now()
                    val systemTZ = TimeZone.currentSystemDefault()
                    val oneMonth = now.plus(1, DateTimeUnit.MONTH, systemTZ)
                    val oneMonthFix = dateOfUseFormatter(oneMonth.toString())
                    call.respond(mapOf("one-month" to oneMonthFix))
                }
            }
        }
    }
}
