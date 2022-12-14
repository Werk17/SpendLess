package com.example.spendless.database.items

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Items(
//    @PrimaryKey(autoGenerate = true)  val id: Int,
    @NonNull @PrimaryKey @ColumnInfo(name = "note") val title: String,
    @ColumnInfo(name = "amount_spent") val amount_spent: String,
    @ColumnInfo(name = "date") val date: String?
)