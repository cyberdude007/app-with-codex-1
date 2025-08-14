package com.hisaabsplit.app.data.database.dao

import androidx.room.*
import com.hisaabsplit.app.data.database.entities.Settlement

@Dao
interface SettlementDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(settlement: Settlement)

    @Update
    suspend fun update(settlement: Settlement)

    @Delete
    suspend fun delete(settlement: Settlement)

    @Query("SELECT * FROM settlements WHERE id = :id")
    suspend fun getById(id: String): Settlement?

    @Query("SELECT * FROM settlements WHERE groupId = :groupId")
    suspend fun getByGroup(groupId: String): List<Settlement>
}
