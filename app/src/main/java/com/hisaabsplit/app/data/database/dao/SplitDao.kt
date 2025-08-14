package com.hisaabsplit.app.data.database.dao

import androidx.room.*
import com.hisaabsplit.app.data.database.entities.Split

@Dao
interface SplitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(split: Split)

    @Update
    suspend fun update(split: Split)

    @Delete
    suspend fun delete(split: Split)

    @Query("SELECT * FROM splits WHERE id = :id")
    suspend fun getById(id: String): Split?

    @Query("SELECT * FROM splits WHERE transactionId = :transactionId")
    suspend fun getByTransaction(transactionId: String): List<Split>
}
