package com.aitortola.landingdemo.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aitortola.landingdemo.R
import com.aitortola.landingdemo.adapters.LandingListItemAdapters
import com.aitortola.landingdemo.databinding.ActivityLandingBinding
import com.aitortola.landingdemo.firebase.FirestoreClass
import com.aitortola.landingdemo.models.Landing
import com.google.firebase.FirebaseApp

class LandingActivity : BaseActivity() {

    private lateinit var binding: ActivityLandingBinding
    private lateinit var mLandingList: ArrayList<Landing>

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        showProgressDialog(getString(R.string.please_wait))
        FirestoreClass().getLandingList(this)
    }

    fun setupLandingList(list: ArrayList<Landing>) {
        mLandingList = list
        hideProgressDialog()

        val gridLayout: RecyclerView = findViewById<RecyclerView>(R.id.mosaicGrid)

        val landingListAdapter = LandingListItemAdapters(this, mLandingList)
        gridLayout.adapter = landingListAdapter
        gridLayout.layoutManager = LinearLayoutManager(this)
    }

}