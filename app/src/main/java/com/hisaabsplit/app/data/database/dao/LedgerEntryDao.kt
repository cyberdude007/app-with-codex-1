package com.hisaabsplit.app.data.database.dao

import androidx.room.*
import com.hisaabsplit.app.data.database.entities.LedgerEntry

@Dao
interface LedgerEntryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry: LedgerEntry)

    @Update
    suspend fun update(entry: LedgerEntry)

    @Delete
    suspend fun delete(entry: LedgerEntry)

    @Query("SELECT * FROM ledger_entries WHERE id = :id")
    suspend fun getById(id: String): LedgerEntry?

    @Query("SELECT * FROM ledger_entries WHERE transactionId = :transactionId")
    suspend fun getByTransaction(transactionId: String): List<LedgerEntry>
}
