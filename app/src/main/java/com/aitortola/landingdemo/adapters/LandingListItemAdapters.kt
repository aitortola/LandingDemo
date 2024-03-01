package com.aitortola.landingdemo.adapters

import android.content.Context
import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aitortola.landingdemo.R
import com.aitortola.landingdemo.models.Landing

class LandingListItemAdapters(private val context: Context, private val landingList: List<Landing>) :
    RecyclerView.Adapter<LandingListItemAdapters.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gridLayout: GridLayout = itemView.findViewById(R.id.gridLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.item_card, parent, false)
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = landingList[position]

        // Configurar el contenido del ViewHolder según el modelo Landing
        holder.btnCard.text = currentItem.Titulo
        holder.btnCard.setTextSize(currentItem.TamanoFuente.toFloat())

        holder.txtCard.text = currentItem.Titulo
        holder.txtCard.textSize = currentItem.TamanoFuente.toFloat()
        // Puedes configurar otros elementos según sea necesario
    }

    override fun getItemCount(): Int {
        return landingList.size
    }
}