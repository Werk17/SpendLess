package com.example.spendless.database.items

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM items ORDER BY note ASC")
    fun getAll(): Flow<List<Items>>

    @Update
    fun updateItem(vararg items: Items)

    @Delete
    fun delete(items: Items)

    @Query("SELECT * FROM items WHERE note = :title ORDER BY amount_spent ASC")
    fun getByPrice(title: String): Flow<List<Items>>
}