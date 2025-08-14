package com.hisaabsplit.app.data.database.dao

import androidx.room.*
import com.hisaabsplit.app.data.database.entities.Member

@Dao
interface MemberDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(member: Member)

    @Update
    suspend fun update(member: Member)

    @Delete
    suspend fun delete(member: Member)

    @Query("SELECT * FROM members WHERE id = :id")
    suspend fun getById(id: String): Member?

    @Query("SELECT * FROM members WHERE groupId = :groupId")
    suspend fun getByGroup(groupId: String): List<Member>
}
