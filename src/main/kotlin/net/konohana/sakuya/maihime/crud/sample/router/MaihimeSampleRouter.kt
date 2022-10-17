package net.konohana.sakuya.maihime.crud.sample.router

import io.ktor.server.routing.Route
import net.konohana.sakuya.maihime.crud.sample.controller.maihimeSampleController

fun Route.maihimeSampleRouter() {
    maihimeSampleController()
}
