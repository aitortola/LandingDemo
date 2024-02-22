package com.aitortola.landingdemo.adapters

import android.content.Context
import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.aitortola.landingdemo.R
import com.aitortola.landingdemo.models.Landing
import com.bumptech.glide.Glide

class LandingListItemAdapters(
    private val context: Context,
    private val list:ArrayList<Landing>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.activity_landing,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]

        if (holder is MyViewHolder) {

            Glide
                .with(context)
                .load(model.Imagen)
                .centerCrop()
                .placeholder(R.drawable.landing_celda_casino)
                .into(holder.itemView.findViewById(R.id.button1))

            val button = holder.itemView.findViewById<Button>(R.id.button1)
            button.text = model.Titulo
            button.textSize = model.TamanoFuente.toFloat()
            button.


        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
}