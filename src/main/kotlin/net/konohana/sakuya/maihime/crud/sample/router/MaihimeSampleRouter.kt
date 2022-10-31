package net.konohana.sakuya.maihime.crud.sample.router

import io.ktor.server.routing.Route
import net.konohana.sakuya.maihime.crud.sample.controller.maihimeDateTimeSampleController
import net.konohana.sakuya.maihime.crud.sample.controller.maihimeSampleController
import net.konohana.sakuya.maihime.crud.sample.controller.maihimeSampleFromFXController
import net.konohana.sakuya.maihime.crud.sample.controller.oneway.onewayTicketAdultRequestController
import net.konohana.sakuya.maihime.crud.sample.controller.oneway.onewayTicketChildRequestController
import net.konohana.sakuya.maihime.crud.sample.controller.oneway.onewayTicketHalfRequestController

fun Route.maihimeSampleRouter() {
    maihimeDateTimeSampleController()
    maihimeSampleController()
    maihimeSampleFromFXController()
    onewayTicketAdultRequestController()
    onewayTicketChildRequestController()
    onewayTicketHalfRequestController()
}
