package com.hisaabsplit.app.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.UUID

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val kind: TransactionKind,
    val title: String,
    val note: String = "",
    val accountId: String,
    val categoryId: String?,
    val amountTotal: BigDecimal,
    val currency: String = "INR",
    val date: Long,
    val groupId: String?,
    val payerMemberId: String?,
    val attachments: List<String> = emptyList(),
    val deleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)
