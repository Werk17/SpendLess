package com.example.spendless.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.spendless.database.items.ItemDao
import com.example.spendless.database.items.Items

class ItemViewModel(private val itemDao: ItemDao): ViewModel() {
    fun allItems(): List<Items> = itemDao.getAll()
}

class ItemViewModelFactory(
    private val itemDao: ItemDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ItemViewModel(itemDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}