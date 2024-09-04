package com.example.assignment4

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContactDetailsActivity : AppCompatActivity() {
    lateinit var nameTextView: TextView
    lateinit var phoneTextView: TextView
    lateinit var descriptionTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)
        nameTextView = findViewById(R.id.nameValue)
        phoneTextView = findViewById(R.id.phoneValue)
        descriptionTextView = findViewById(R.id.descriptionValue)
        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val description = intent.getStringExtra("description")
        nameTextView.text= name
        phoneTextView.text = phone
        descriptionTextView.text = description

    }
}