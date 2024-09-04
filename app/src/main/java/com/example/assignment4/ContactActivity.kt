package com.example.assignment4

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class ContactActivity : AppCompatActivity() {
    lateinit var nameTextView : TextView
    lateinit var phoneTextView : TextView
    lateinit var descriptionTextView : TextView
    lateinit var saveButton : Button
    lateinit var contactRecyclerView: RecyclerView
    lateinit var adapter: ContactAdapter
    lateinit var contactsList: MutableList<ContactItem>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        nameTextView = findViewById(R.id.name_field)
        phoneTextView = findViewById(R.id.phone_field)
        descriptionTextView = findViewById(R.id.description_field)
        saveButton= findViewById(R.id.confirm_button)
        contactRecyclerView = findViewById(R.id.contact_recycler_view)
        contactsList = mutableListOf()

        adapter = ContactAdapter(contactsList)
        adapter.onItemClick = object : OnContactItemClickListener{
            override fun onContactItemClick(contactItem: ContactItem, position: Int) {
                val intent = Intent(this@ContactActivity , ContactDetailsActivity::class.java)
                intent.putExtra("name" , contactItem.name)
                intent.putExtra("phone" , contactItem.phone)
                intent.putExtra("description" , contactItem.description)
                startActivity(intent)
            }
        }
        contactRecyclerView.adapter=adapter



    }
    fun onButtonClick(view: View?) {
        if (view is Button) {
            val button = view
            val name :String = nameTextView.text.toString()
            val phone :String = phoneTextView.text.toString()
            val description :String = descriptionTextView.text.toString()

            val nameErrorText = findViewById<TextView>(R.id.nameErrorText)
            val phoneErrorText = findViewById<TextView>(R.id.phoneErrorText)

            nameErrorText.visibility = View.GONE
            phoneErrorText.visibility = View.GONE

            var hasError = false

            if (name.isBlank()) {
                nameErrorText.visibility = View.VISIBLE
                hasError = true
            }


            if (phone.isBlank()) {
                phoneErrorText.visibility = View.VISIBLE
                hasError = true
            }

            if (!hasError) {
                val contact = ContactItem(name, phone, description)
                contactsList.add(contact)
                contactRecyclerView.adapter?.notifyDataSetChanged()
                contactRecyclerView.visibility = View.VISIBLE
            }
        }
    }


}