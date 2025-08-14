package com.hisaabsplit.app.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.UUID

@Entity(tableName = "ledger_entries")
data class LedgerEntry(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val transactionId: String,
    val entryType: LedgerEntryType,
    val accountId: String?,
    val memberId: String?,
    val categoryId: String?,
    val amountSigned: BigDecimal,
    val currency: String = "INR",
    val createdAt: Long = System.currentTimeMillis()
)
