package net.konohana.sakuya.maihime.crud.sample.router

import io.ktor.server.routing.Route
import net.konohana.sakuya.maihime.crud.sample.controller.maihimeSampleController
import net.konohana.sakuya.maihime.crud.sample.controller.oneway.onewayTicketAdultRequestController

fun Route.maihimeSampleRouter() {
    maihimeSampleController()
    onewayTicketAdultRequestController()
}
