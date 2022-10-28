package net.konohana.sakuya.maihime.crud.sample.controller.oneway

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import net.konohana.sakuya.maihime.crud.sample.domain.service.OnewayTicketHalfRequestService

fun Route.onewayTicketHalfRequestController() {
    route("oneway") {
        route("half") {
            post {
                val request = call.receive<OnewayTicketHalfRequestDataFromAPI>()
                val id = OnewayTicketHalfRequestService.create(
                    request.requestNo,
                    request.ticketNo,
                    request.fromSta,
                    request.toSta,
                    request.via,
                    request.fare,
                    request.dayOfUse
                )
                call.respond(mapOf("id" to id))
            }
            get("/{id}") {
                val id = call.parameters["id"]?.toInt() ?: run {
                    return@get call.respond(HttpStatusCode.BadRequest, "IDが指定されていません")
                }
                val onewayTicketHalfReq = OnewayTicketHalfRequestService.find(id) ?: run {
                    return@get call.respond(HttpStatusCode.NotFound, "データが存在しません id: $id")
                }
                call.respond(onewayTicketHalfReq)
            }
        }
    }
}

data class OnewayTicketHalfRequestDataFromAPI(
    val requestNo: String,
    val ticketNo: String,
    val fromSta: String,
    val toSta: String,
    val via: String,
    val fare: String,
    val dayOfUse: String,
)
