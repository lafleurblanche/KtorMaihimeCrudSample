package net.konohana.sakuya.maihime.crud.sample.domain.model.oneway

/**
 * ## 片道乗車券発券要求データクラス
 * * 自社線内半額運賃
 * @author lafleurblanche
 */
data class OnewayTicketHalfRequest(
    val id: Int,
    val requestNo: String,
    val ticketNo: String,
    val fromSta: String,
    val toSta: String,
    val via: String,
    val fare: String,
    val dayOfUse: String,
)
