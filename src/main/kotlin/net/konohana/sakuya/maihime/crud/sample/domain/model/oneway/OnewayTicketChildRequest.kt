package net.konohana.sakuya.maihime.crud.sample.domain.model.oneway

/**
 * ## 片道乗車券発券要求データクラス
 * * 自社線内小児運賃
 * @author lafleurblanche
 */
data class OnewayTicketChildRequest(
    val id: Int,
    val requestNo: String,
    val ticketNo: String,
    val fromSta: String,
    val toSta: String,
    val via: String,
    val fare: String,
    val dayOfUse: String,
)
