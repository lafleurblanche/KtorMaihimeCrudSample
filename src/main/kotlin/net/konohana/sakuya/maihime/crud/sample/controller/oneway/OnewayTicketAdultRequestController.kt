package net.konohana.sakuya.maihime.crud.sample.controller.oneway

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import net.konohana.sakuya.maihime.crud.sample.domain.service.OnewayTicketAdultRequestService

fun Route.onewayTicketAdultRequestController() {
    route("oneway") {
        route("adult") {
            post {
                val request = call.receive<OnewayTicketAdultRequestDataFromAPI>()
                val id = OnewayTicketAdultRequestService.create(
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
                val id = call.parameters["id"]?.let { it.toInt() } ?: run {
                    return@get call.respond(HttpStatusCode.BadRequest, "IDが指定されていません")
                }
                val onewayTicketAdultReq = OnewayTicketAdultRequestService.find(id) ?: run {
                    return@get call.respond(HttpStatusCode.NotFound, "データが存在しません id: $id")
                }
                call.respond(onewayTicketAdultReq)
            }
        }
    }
}

data class OnewayTicketAdultRequestDataFromAPI(
    val requestNo: String,
    val ticketNo: String,
    val fromSta: String,
    val toSta: String,
    val via: String,
    val fare: String,
    val dayOfUse: String,
)
