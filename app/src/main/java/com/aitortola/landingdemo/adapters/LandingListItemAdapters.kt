package com.aitortola.landingdemo.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.aitortola.landingdemo.AutoResizeTextView
import com.aitortola.landingdemo.R
import com.aitortola.landingdemo.activities.LandingActivity
import com.aitortola.landingdemo.models.Landing

class LandingListItemAdapters(
    private val context: Context,
    private val landingList: List<Landing>
) :
    RecyclerView.Adapter<LandingListItemAdapters.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context)
            .inflate(
                R.layout.item_card,
                parent,
                false
            )
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = landingList[position]
//
//        val tvTitulo = holder.itemView.findViewById<AutoResizeTextView>(R.id.textButtonLive)
//        val btnLive = holder.itemView.findViewById<Button>(R.id.buttonLive)
//
//        tvTitulo.text = currentItem.Titulo
//        tvTitulo.textSize = currentItem.TamanoFuente.toFloat()
//
//        if (currentItem.ColorFondo != "") {
//            btnLive.setBackgroundColor(Color.parseColor("#" + currentItem.ColorFondo))
//        } else {
//            btnLive.setBackgroundColor(Color.parseColor("#ffffff"))
//        }

//        val params = GridLayout.LayoutParams()
//        params.width = 0
//        params.height = GridLayout.LayoutParams.WRAP_CONTENT
//        params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
//        params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
//        holder.itemView.layoutParams = params


            val currentText: AutoResizeTextView = holder.itemView.findViewById(R.id.textButtonLive)
            val currentButton: Button = holder.itemView.findViewById(R.id.buttonLive)
            currentText.text = currentItem.Titulo
            currentText.textSize = currentItem.TamanoFuenteTablet.toFloat()
            if (currentItem.ColorFondo != "") {
                currentButton.setBackgroundColor(Color.parseColor("#" + currentItem.ColorTitulo))
            } else {
                currentButton.setBackgroundColor(Color.parseColor("#ffffff"))
            }


        // Puedes configurar otros elementos según sea necesario
    }

    override fun getItemCount(): Int {
        return landingList.size
    }

}