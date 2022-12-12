package com.example.spendless.database.items

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Items(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val title: String?,
    @NonNull @ColumnInfo(name = "amount_spent") val amount_spent: Double,
    @ColumnInfo(name = "date") val date: String?
)