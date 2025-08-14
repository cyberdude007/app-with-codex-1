package com.hisaabsplit.app.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "labels")
data class Label(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val name: String,
    val color: String
)
