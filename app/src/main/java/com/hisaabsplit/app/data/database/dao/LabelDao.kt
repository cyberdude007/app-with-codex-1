package com.hisaabsplit.app.data.database.dao

import androidx.room.*
import com.hisaabsplit.app.data.database.entities.Label

@Dao
interface LabelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(label: Label)

    @Update
    suspend fun update(label: Label)

    @Delete
    suspend fun delete(label: Label)

    @Query("SELECT * FROM labels WHERE id = :id")
    suspend fun getById(id: String): Label?

    @Query("SELECT * FROM labels")
    suspend fun getAll(): List<Label>
}
