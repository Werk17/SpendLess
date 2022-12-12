package com.example.spendless

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spendless.model.UserData
import com.example.spendless.view.UserAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recy: RecyclerView
    private lateinit var userList: ArrayList<UserData>
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//  set list
        userList = ArrayList()

//        set find ID
        addsBtn = findViewById(R.id.addingBtn)
        recy = findViewById(R.id.budgetRecycler)
//        set adapter
        userAdapter = UserAdapter(this, userList)
//        set Recycler view adapter
        recy.layoutManager = LinearLayoutManager(this)
        recy.adapter = userAdapter

//        set Dialog
        addsBtn.setOnClickListener {
            addInfo()
        }
    }

    private fun addInfo() {
        val inflater = LayoutInflater.from(this)
        val v = inflater.inflate(R.layout.add_item, null)
//        set view
        val item = v.findViewById<EditText>(R.id.itemName)
        val price = v.findViewById<EditText>(R.id.price)
        val addDialog = AlertDialog.Builder(this)
        addDialog.setView(v)
        addDialog.setPositiveButton("Ok") { dialog, _ ->
            val items = item.text.toString()
            val itemPrice = price.text.toString()

            userList.add(UserData("$items", "Spent: $$itemPrice", "date"))
            userAdapter.notifyDataSetChanged()
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
        }
        addDialog.create()
        addDialog.show()
    }


}