package com.aitortola.landingdemo.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
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

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
    }

    fun setupLandingList(list: ArrayList<Landing>) {
        mLandingList = list
        hideProgressDialog()

        val rvLandingList = binding.recyclerView
        rvLandingList.layoutManager = LinearLayoutManager(this)
        rvLandingList.setHasFixedSize(true)

        val adapter = LandingListItemAdapters(this@LandingActivity, mLandingList)
        rvLandingList.adapter = adapter
    }

}