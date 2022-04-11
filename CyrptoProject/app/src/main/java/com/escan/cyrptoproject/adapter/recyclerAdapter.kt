package com.escan.cyrptoproject.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.escan.cyrptoproject.R
import com.escan.cyrptoproject.model.CryptoModel
import kotlinx.android.synthetic.main.recycler_row.view.*

class recyclerAdapter(private val cryptolist: ArrayList<CryptoModel>,private val listener: Listener): RecyclerView.Adapter<recyclerAdapter.RowHolder>() {

    val colors: Array<String> = arrayOf("#2bf04c","#42f5ef","#f02b4f","#f0d62b")

   interface Listener{
       fun onItemClick(cryptoModel: CryptoModel)
   }

    class RowHolder(view: View):RecyclerView.ViewHolder(view){
        fun bind(cryptoModel: CryptoModel,colors:Array<String>,position:Int,listener: Listener){
            itemView.setOnClickListener {
                listener.onItemClick(cryptoModel)
            }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 3]))
            itemView.text_name.text = cryptoModel.currency
            itemView.text_price.text = cryptoModel.price
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return RowHolder(itemView)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptolist[position],colors,position,listener)
    }

    override fun getItemCount(): Int {
        return  cryptolist.size
    }
}