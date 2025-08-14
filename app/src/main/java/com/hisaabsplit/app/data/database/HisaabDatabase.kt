package com.hisaabsplit.app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hisaabsplit.app.data.database.dao.*
import com.hisaabsplit.app.data.database.entities.*
import net.sqlcipher.database.SupportFactory

@Database(
    entities = [
        Account::class,
        Category::class,
        Label::class,
        Group::class,
        Member::class,
        Transaction::class,
        Split::class,
        LedgerEntry::class,
        Settlement::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class HisaabDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao
    abstract fun categoryDao(): CategoryDao
    abstract fun labelDao(): LabelDao
    abstract fun groupDao(): GroupDao
    abstract fun memberDao(): MemberDao
    abstract fun transactionDao(): TransactionDao
    abstract fun splitDao(): SplitDao
    abstract fun ledgerEntryDao(): LedgerEntryDao
    abstract fun settlementDao(): SettlementDao

    companion object {
        @Volatile
        private var INSTANCE: HisaabDatabase? = null

        fun getDatabase(context: Context): HisaabDatabase {
            return INSTANCE ?: synchronized(this) {
                val passphrase = getOrCreatePassphrase(context)
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HisaabDatabase::class.java,
                    "hisaab_database"
                )
                    .openHelperFactory(SupportFactory(passphrase))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private fun getOrCreatePassphrase(context: Context): ByteArray {
            // TODO: Generate or retrieve encrypted passphrase
            return ByteArray(0)
        }
    }
}
