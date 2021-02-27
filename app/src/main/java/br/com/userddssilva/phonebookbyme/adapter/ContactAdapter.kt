package br.com.userddssilva.phonebookbyme.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.userddssilva.phonebookbyme.R
import br.com.userddssilva.phonebookbyme.model.Contact

class ContactAdapter(
    private val contacts: List<Contact>
): RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = contacts[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int = contacts.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item: Contact) = with(itemView) {
            val tvContactName = findViewById<TextView>(R.id.tvContactName)
            val tvContactPhone = findViewById<TextView>(R.id.tvContactPhone)

            tvContactName.text = item.name
            tvContactPhone.text = item.phone
        }
    }
}