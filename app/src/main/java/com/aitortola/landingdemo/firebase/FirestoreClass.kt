package com.aitortola.landingdemo.firebase

import android.util.Log
import com.aitortola.landingdemo.activities.LandingActivity
import com.aitortola.landingdemo.models.Landing
import com.google.firebase.firestore.FieldPath
import com.google.firebase.firestore.FirebaseFirestore

class FirestoreClass {
    private val mFireStore = FirebaseFirestore.getInstance()
    fun getLandingList(activity: LandingActivity) {
        mFireStore.collection("Landing")
            .document("1")
            .collection("Tarjeta")
            .orderBy(FieldPath.documentId())
            .get()
            .addOnSuccessListener { document ->
                Log.i(activity.javaClass.simpleName, document.documents.toString())
                val landingList: ArrayList<Landing> = ArrayList()
                for (i in document.documents) {
                    val landing = i.toObject(Landing::class.java)
                    if (landing != null) {
                        landingList.add(landing)
                    }
                }
                activity.setupLandingList(landingList)
                activity.hideProgressDialog()
            }
            .addOnFailureListener { e ->
                activity.hideProgressDialog()
                Log.e(
                    activity.javaClass.simpleName,
                    e.stackTraceToString() + "--> Error while getting landing list.",
                )
            }
    }
}