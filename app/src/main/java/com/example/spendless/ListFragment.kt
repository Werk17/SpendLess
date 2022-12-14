package com.example.spendless

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spendless.database.items.Items
import com.example.spendless.databinding.FragmentListBinding
import com.example.spendless.view.ItemAdapter
import com.example.spendless.viewmodels.ItemViewModel
import com.example.spendless.viewmodels.ItemViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding
    private lateinit var recyclerView: RecyclerView
    private lateinit var addsBtn: FloatingActionButton
    private lateinit var userList: ArrayList<Items>
    private lateinit var userAdapter: ItemAdapter

    private val viewModel: ItemViewModel by activityViewModels {
        ItemViewModelFactory(
            (activity?.application as ItemApplication).database.itemDao()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        /  set list
//        userList = ArrayList<Items>()

//        set find ID
//        addsBtn = binding!!.addingBtn
//        recyclerView = binding!!.budgetRecycler
//////        set adapter
////        userAdapter = ItemAdapter(requireContext())
//////        set Recycler view adapter
////        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = userAdapter
//
////        set Dialog
//        addsBtn.setOnClickListener {
//            addInfo()
//        }
////        arguments?.let {
////            _binding = it.getString()
////            param2 = it.getString(ARG_PARAM2)
////        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = (binding?.budgetRecycler ?: null) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val itemAdapter = ItemAdapter({
//            val action = ListFragmentDirections.actionListFragmentSelf()
//            view.findNavController().navigate(action)
        })
        recyclerView.adapter = itemAdapter
        lifecycle.coroutineScope.launch {
            viewModel.allItems().collect() {
                itemAdapter.submitList((it))
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun addInfo() {
        val inflater = LayoutInflater.from(requireContext())
        val v = inflater.inflate(R.layout.add_item, null)
//        set views
        val item = v.findViewById<EditText>(R.id.itemName)
        val price = v.findViewById<EditText>(R.id.price)
        val date = v.findViewById<EditText>(R.id.noteDate)
        val addDialog = AlertDialog.Builder(requireContext())
        addDialog.setView(v)

//        Set positive button
        addDialog.setPositiveButton("Ok") { dialog, _ ->
            val items = item.text.toString()
            val itemPrice = price.text.toString()
            val noteDate = date.text.toString()
            userList.add(Items("$items", "Spent: $$itemPrice", "Date: $noteDate"))
            userAdapter.notifyDataSetChanged()
//            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
//        negative button
        addDialog.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
//            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
        }

        addDialog.create()
        addDialog.show()
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment ListFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            ListFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}