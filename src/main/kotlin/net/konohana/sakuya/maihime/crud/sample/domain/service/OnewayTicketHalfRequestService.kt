package net.konohana.sakuya.maihime.crud.sample.domain.service

import net.konohana.sakuya.maihime.crud.sample.data.oneway.OnewayTicketHalfRequestRepository

object OnewayTicketHalfRequestService {
    fun create(
        requestNo: String,
        ticketNo: String,
        fromSta: String,
        toSta: String,
        via: String,
        fare: String,
        dayOfUse: String,
    ) = OnewayTicketHalfRequestRepository.create(
        requestNo,
        ticketNo,
        fromSta,
        toSta,
        via,
        fare,
        dayOfUse
    )
    fun find(id: Int) = OnewayTicketHalfRequestRepository.find(id)
}
