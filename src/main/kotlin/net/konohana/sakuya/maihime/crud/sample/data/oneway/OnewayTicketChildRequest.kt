package net.konohana.sakuya.maihime.crud.sample.data.oneway

import net.konohana.sakuya.maihime.crud.sample.domain.model.oneway.OnewayTicketChildRequest
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * ## 片道乗車券発券要求テーブル
 * * 自社線内半額運賃
 * @author lafleurblanche
 */
object OnewayTicketChildRequestTable : IntIdTable("oneway_ticket_adult_request") {
    val requestNo: Column<String> = varchar("request_no", length = 20)
    val ticketNo: Column<String> = varchar("ticket_no", length = 20)
    val fromSta: Column<String> = varchar("from_sta", length = 20)
    val toSta: Column<String> = varchar("to_sta", length = 20)
    val via: Column<String> = varchar("via", length = 20)
    val fare: Column<String> = varchar("fare", length = 20)
    val dayOfUse: Column<String> = varchar("day_of_use", length = 20)
}

object OnewayTicketChildRequestRepository {
    fun create(
        requestNo: String,
        ticketNo: String,
        fromSta: String,
        toSta: String,
        via: String,
        fare: String,
        dayOfUse: String,
    ) {
        transaction {
            OnewayTicketChildRequestTable.insertAndGetId {
                it[this.requestNo] = requestNo
                it[this.ticketNo] = ticketNo
                it[this.fromSta] = fromSta
                it[this.toSta] = toSta
                it[this.via] = via
                it[this.fare] = fare
                it[this.dayOfUse] = dayOfUse
            }.value
        }
    }

    fun find(id: Int) = transaction {
        OnewayTicketChildRequestTable.select { OnewayTicketChildRequestTable.id eq id }.singleOrNull()?.let {
            OnewayTicketChildRequest(
                it[OnewayTicketChildRequestTable.id].value,
                it[OnewayTicketChildRequestTable.requestNo],
                it[OnewayTicketChildRequestTable.ticketNo],
                it[OnewayTicketChildRequestTable.fromSta],
                it[OnewayTicketChildRequestTable.toSta],
                it[OnewayTicketChildRequestTable.via],
                it[OnewayTicketChildRequestTable.fare],
                it[OnewayTicketChildRequestTable.dayOfUse],
            )
        }
    }
}
