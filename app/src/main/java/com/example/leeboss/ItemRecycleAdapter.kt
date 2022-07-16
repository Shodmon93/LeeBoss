package com.example.leeboss

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list_view.view.*
import org.w3c.dom.Text

class ItemRecycleAdapter(val onClick: OnClickListener) : RecyclerView.Adapter<ItemRecycleAdapter.ViewHolder>(){

    private var item : ArrayList<LeeBoss> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_view,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item[position])
        holder.itemView.setOnClickListener {
            onClick.onClickListener(item[position])
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun setDat (leeBoss: ArrayList<LeeBoss>){
        val data = LeeBossModule.setData()
        item = data
    }


    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        private val image : ImageView = view.image
        private val brand : TextView = view.brand
        private val series : TextView = view.series
        private val size : TextView = view.size
        private val colour : TextView = view.colour

        fun bind(leeBoss: LeeBoss){
            brand.text = leeBoss.brand
            series.text = leeBoss.series
            size.text = leeBoss.size.toString()
            colour.text = leeBoss.colour
        }

    }
    class OnClickListener(val onClickListener : (leeBoss : LeeBoss) -> Unit){
        fun onClick (leeboss: LeeBoss) = onClickListener(leeboss)
    }
}