package com.example.leeboss

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_entry.*

class EntryFragment : Fragment() {
    private lateinit var itemAdapter: ItemRecycleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_entry, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data  = LeeBossModule.setData()
        itemAdapter = ItemRecycleAdapter(ItemRecycleAdapter.OnClickListener{
            Toast.makeText(activity,"${it.brand} clicked", Toast.LENGTH_SHORT).show()
        })
        itemAdapter.setDat(data)
        item_list.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = itemAdapter
        }
    }
}