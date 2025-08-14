package com.hisaabsplit.app.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.UUID

@Entity(tableName = "settlements")
data class Settlement(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val groupId: String,
    val fromMemberId: String,
    val toMemberId: String,
    val accountId: String?,
    val amount: BigDecimal,
    val method: SettlementMethod,
    val date: Long,
    val note: String = "",
    val linkedTransactionId: String?
)
