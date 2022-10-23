package net.konohana.sakuya.maihime.crud.sample.data.oneway

import net.konohana.sakuya.maihime.crud.sample.domain.model.oneway.OnewayTicketAdultRequest
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * ## 片道乗車券発券要求テーブル
 * * 自社線内大人運賃
 * @author lafleurblanche
 */
object OnewayTicketAdultRequestTable : IntIdTable("oneway_ticket_adult_request") {
    val requestNo: Column<String> = varchar("request_no", length = 20)
    val ticketNo: Column<String> = varchar("ticket_no", length = 20)
    val fromSta: Column<String> = varchar("from_sta", length = 20)
    val toSta: Column<String> = varchar("to_sta", length = 20)
    val via: Column<String> = varchar("via", length = 20)
    val fare: Column<String> = varchar("fare", length = 20)
    val dayOfUse: Column<String> = varchar("day_of_use", length = 20)
}

object OnewayTicketAdultRequestRepository {
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
            OnewayTicketAdultRequestTable.insertAndGetId {
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
        OnewayTicketAdultRequestTable.select { OnewayTicketAdultRequestTable.id eq id }.singleOrNull()?.let {
            OnewayTicketAdultRequest(
                it[OnewayTicketAdultRequestTable.id].value,
                it[OnewayTicketAdultRequestTable.requestNo],
                it[OnewayTicketAdultRequestTable.ticketNo],
                it[OnewayTicketAdultRequestTable.fromSta],
                it[OnewayTicketAdultRequestTable.toSta],
                it[OnewayTicketAdultRequestTable.via],
                it[OnewayTicketAdultRequestTable.fare],
                it[OnewayTicketAdultRequestTable.dayOfUse],
            )
        }
    }
}
