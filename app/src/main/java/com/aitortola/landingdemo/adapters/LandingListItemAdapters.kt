package com.aitortola.landingdemo.adapters

import android.content.Context
import android.content.DialogInterface.OnClickListener
import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aitortola.landingdemo.R
import com.aitortola.landingdemo.models.Landing

class LandingListItemAdapters(
    private val context: Context,
    private val list: ArrayList<Landing>
) : RecyclerView.Adapter<LandingListItemAdapters.MosaicViewHolder>() {
    private var onClickListener: OnClickListener? = null

    class MosaicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView = itemView.findViewById(R.id.tvCard)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MosaicViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_landing, parent, false)
        return MosaicViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MosaicViewHolder, position: Int) {
        val model = list[position]

        val tvTitulo: TextView = holder.itemView.findViewById(R.id.tvCard)

        tvTitulo.text = model.Titulo

        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position)
            }

        }
    }

    private fun esTablet(context: Context): Boolean {
        return context.resources.configuration.screenLayout >= Configuration.SCREENLAYOUT_SIZE_LARGE && Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
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