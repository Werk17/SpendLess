package com.example.spendless.database.items

import androidx.room.Dao
import androidx.room.Query
import com.example.spendless.model.UserData

@Dao
interface ItemDao {

    @Query("SELECT * FROM items ORDER BY id ASC")
    fun getAll(): List<Items>
}