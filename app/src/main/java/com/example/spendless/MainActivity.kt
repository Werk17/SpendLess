package com.example.spendless

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spendless.database.items.Items
import com.example.spendless.databinding.ActivityMainBinding
import com.example.spendless.databinding.FragmentListBinding
import com.example.spendless.model.UserData
import com.example.spendless.view.ItemAdapter
import com.example.spendless.viewmodels.ItemViewModel
import com.example.spendless.viewmodels.ItemViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
//    private lateinit var addsBtn: FloatingActionButton
//    private lateinit var recy: RecyclerView
//    private lateinit var userList: ArrayList<Items>
//    private lateinit var userAdapter: ItemAdapter
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val binding = ActivityMainBinding.inflate(layoutInflater)
        val binding = FragmentListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)


//  set list
//        userList = ArrayList<Items>()

//        set find ID
//        addsBtn = findViewById(R.id.addingBtn)
//        recy = findViewById(R.id.budgetRecycler)
////        set adapter
//        userAdapter = ItemAdapter(this)
////        set Recycler view adapter
//        recy.layoutManager = LinearLayoutManager(this)
//        recy.adapter = userAdapter
//
////        set Dialog
//        addsBtn.setOnClickListener {
//            addInfo()
//        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


//    private fun addInfo() {
//        val inflater = LayoutInflater.from(this)
//        val v = inflater.inflate(R.layout.add_item, null)
////        set view
//        val item = v.findViewById<EditText>(R.id.itemName)
//        val price = v.findViewById<EditText>(R.id.price)
//        val date = v.findViewById<EditText>(R.id.noteDate)
//        val addDialog = AlertDialog.Builder(this)
//        addDialog.setView(v)
//        addDialog.setPositiveButton("Ok") { dialog, _ ->
//            val items = item.text.toString()
//            val itemPrice = price.text.toString()
//            val noteDate = date.text.toString()
//            userList.add(Items(0, "$items", "Spent: $$itemPrice", "Date: $noteDate"))
//            userAdapter.notifyDataSetChanged()
//            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
//            dialog.dismiss()
//        }
//        addDialog.setNegativeButton("Cancel") { dialog, _ ->
//            dialog.dismiss()
//            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
//        }
//        addDialog.create()
//        addDialog.show()
//    }


}