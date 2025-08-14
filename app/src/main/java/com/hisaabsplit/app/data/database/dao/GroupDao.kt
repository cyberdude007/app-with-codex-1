package com.hisaabsplit.app.data.database.dao

import androidx.room.*
import com.hisaabsplit.app.data.database.entities.Group

@Dao
interface GroupDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(group: Group)

    @Update
    suspend fun update(group: Group)

    @Delete
    suspend fun delete(group: Group)

    @Query("SELECT * FROM `groups` WHERE id = :id")
    suspend fun getById(id: String): Group?

    @Query("SELECT * FROM `groups`")
    suspend fun getAll(): List<Group>
}
