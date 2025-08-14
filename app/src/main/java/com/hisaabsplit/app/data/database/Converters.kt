package com.hisaabsplit.app.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hisaabsplit.app.data.database.entities.*
import java.math.BigDecimal

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromBigDecimal(value: BigDecimal?): String? = value?.toPlainString()

    @TypeConverter
    fun toBigDecimal(value: String?): BigDecimal? = value?.let { BigDecimal(it) }

    @TypeConverter
    fun fromStringList(list: List<String>?): String? = list?.let { gson.toJson(it) }

    @TypeConverter
    fun toStringList(json: String?): List<String> =
        json?.let {
            val type = object : TypeToken<List<String>>() {}.type
            gson.fromJson<List<String>>(it, type)
        } ?: emptyList()

    @TypeConverter
    fun fromAccountType(value: AccountType?): String? = value?.name

    @TypeConverter
    fun toAccountType(value: String?): AccountType? = value?.let { AccountType.valueOf(it) }

    @TypeConverter
    fun fromTransactionType(value: TransactionType?): String? = value?.name

    @TypeConverter
    fun toTransactionType(value: String?): TransactionType? = value?.let { TransactionType.valueOf(it) }

    @TypeConverter
    fun fromTransactionKind(value: TransactionKind?): String? = value?.name

    @TypeConverter
    fun toTransactionKind(value: String?): TransactionKind? = value?.let { TransactionKind.valueOf(it) }

    @TypeConverter
    fun fromSplitStatus(value: SplitStatus?): String? = value?.name

    @TypeConverter
    fun toSplitStatus(value: String?): SplitStatus? = value?.let { SplitStatus.valueOf(it) }

    @TypeConverter
    fun fromLedgerEntryType(value: LedgerEntryType?): String? = value?.name

    @TypeConverter
    fun toLedgerEntryType(value: String?): LedgerEntryType? = value?.let { LedgerEntryType.valueOf(it) }

    @TypeConverter
    fun fromSettlementMethod(value: SettlementMethod?): String? = value?.name

    @TypeConverter
    fun toSettlementMethod(value: String?): SettlementMethod? = value?.let { SettlementMethod.valueOf(it) }
}
