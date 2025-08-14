package com.hisaabsplit.app.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "members")
data class Member(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val groupId: String,
    val displayName: String,
    val notes: String = "",
    val isSelf: Boolean = false,
    val avatarColor: String,
    val createdAt: Long = System.currentTimeMillis()
)
