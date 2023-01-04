package com.example.cobafirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cobafirebase.databinding.ActivityMainBinding
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
        }


        fetchData()


}

    private fun fetchData() {
        FirebaseFirestore.getInstance().collection("userImages")
            .get()
            .addOnSuccessListener  { documents ->
                for (document in documents){
                val user = documents.toObjects(model::class.java)
                    binding.recyclerview.adapter = adapter(this,user)
                }

            }
            .addOnFailureListener {
            Toast("An error occured :${it.localizedMessage}")
            }
    }
}