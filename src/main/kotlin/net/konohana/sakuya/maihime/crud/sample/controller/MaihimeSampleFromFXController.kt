package net.konohana.sakuya.maihime.crud.sample.controller

import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route

fun Route.maihimeSampleFromFXController() {
    route("maihime") {
        route("sample") {
            route("fromfx/{sample}/{sample2}") {
                get {
                    val reqSample = call.parameters["sample"]
                    val reqSample2 = call.parameters["sample2"]
                    println(reqSample)
                    println(reqSample2)
                    call.respond(mapOf("res" to "OK"))
                }
            }
            route("fromfx") {
                post {
                    val req1 = call.request.queryParameters["req"]
                    println(req1)
                    call.respond(mapOf("res" to "OK"))
                }
            }
        }
    }
}
