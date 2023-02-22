package net.konohana.sakuya.maihime.crud.sample.utils.date

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun getNowTimeString(): String {
    val now = Clock.System.now()
    val thisTime: LocalTime = now.toLocalDateTime(TimeZone.of("Asia/Tokyo")).time
    val thisTimeSep = thisTime.toString().substring(0,8)
    val nowString = now.toString().substring(0, 11)
    return nowString + thisTimeSep
}
