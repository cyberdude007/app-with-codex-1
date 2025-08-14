package com.hisaabsplit.app.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.UUID

@Entity(tableName = "accounts")
data class Account(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val name: String,
    val type: AccountType,
    val openingBalance: BigDecimal,
    val currentBalance: BigDecimal,
    val archived: Boolean = false,
    val icon: String,
    val color: String,
    val createdAt: Long = System.currentTimeMillis()
)
