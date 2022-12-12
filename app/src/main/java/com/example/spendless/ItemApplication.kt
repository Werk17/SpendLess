package com.example.spendless

import android.app.Application
import com.example.spendless.database.items.AppDatabase

class ItemApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}