package net.konohana.sakuya.maihime.crud.sample.controller

import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import net.konohana.sakuya.maihime.crud.sample.dao.request.MaihimeSampleRequest
import net.konohana.sakuya.maihime.crud.sample.dao.response.MaihimeSampleResponse

fun Route.maihimeSampleController() {
    route("maihime") {
        route("sample") {
            post {
                val param = call.receive<MaihimeSampleRequest>()
                println(param.sampleValue)
                call.respond(MaihimeSampleResponse("OK", "request:${param.sampleValue}"))
            }
        }
        route("sample2") {
            post {
                val param = call.receive<MaihimeSampleRequest>()
                println(param.sampleValue)
                call.respond(MaihimeSampleResponse("BadRequest", "リクエスト不正"))
            }
        }
    }
}
