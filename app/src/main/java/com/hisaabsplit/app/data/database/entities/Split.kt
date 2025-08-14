package com.hisaabsplit.app.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.UUID

@Entity(tableName = "splits")
data class Split(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val transactionId: String,
    val memberId: String,
    val shareAmount: BigDecimal,
    val sharePercent: Double?,
    val shareCount: Int?,
    val included: Boolean = true,
    val status: SplitStatus,
    val settledAmount: BigDecimal = BigDecimal.ZERO
)
