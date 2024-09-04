package com.example.assignment4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(val contactsList : List<ContactItem>) : RecyclerView.Adapter<ContactAdapter.ContactItemViewHolder>() {
    var onItemClick : OnContactItemClickListener ? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactItemViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.getContext());
        val view: View = inflater.inflate(R.layout.contact_item , parent , false);
        return ContactItemViewHolder(view);
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    override fun onBindViewHolder(holder: ContactItemViewHolder, position: Int) {
        val item : ContactItem = contactsList.get(position)
//        holder.icon.setImageResource(item.icon ?: R.drawable.name_ic)
        holder.name.text= item.name
        holder.phone.text = item.phone

        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //Activity is the one that should navigation
                //Single Responsibilty principle
                //We use Interface call back known as delegate
                onItemClick?.onContactItemClick(contactItem = item, position = position)
                TODO("Not yet implemented")
            }
        })


    }
    class ContactItemViewHolder(view: View) : RecyclerView.ViewHolder(view){
//        val icon: ImageView = view.findViewById(R.id.contactNameTextView)
        val name: TextView = view.findViewById(R.id.contactNameTextView)
        val phone: TextView = view.findViewById(R.id.contactPhoneTextView)

    }


}