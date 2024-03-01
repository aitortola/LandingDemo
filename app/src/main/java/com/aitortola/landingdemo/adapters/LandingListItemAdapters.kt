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
        val gridLayout: GridLayout = itemView.findViewById(R.id.mosaicGrid)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.item_card, parent, false)
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = landingList[position]

        holder.gridLayout.removeAllViews()
        // Configurar el contenido del ViewHolder según el modelo Landing
        for (i in 1..6) {
            val button = Button(context)
            button.layoutParams = GridLayout.LayoutParams().apply {
                width = GridLayout.LayoutParams.WRAP_CONTENT
                height = GridLayout.LayoutParams.WRAP_CONTENT
                columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                setMargins(8,8,8,8)
            }
            button.text = "${currentItem.Titulo}"
            holder.gridLayout.addView(button)
        }

        // Puedes configurar otros elementos según sea necesario
    }

    override fun getItemCount(): Int {
        return landingList.size
    }
}