package br.com.userddssilva.contactsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.userddssilva.contactsapp.R
import br.com.userddssilva.contactsapp.model.Contact
import br.com.userddssilva.contactsapp.viewholder.ContactItemViewHolder

class ContactListAdapter(
    private val contacts: List<Contact>
) : RecyclerView.Adapter<ContactItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactItemViewHolder, position: Int) {
        val item = contacts[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int = contacts.size
}