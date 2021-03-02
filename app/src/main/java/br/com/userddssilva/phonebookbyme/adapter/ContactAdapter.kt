package br.com.userddssilva.phonebookbyme.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.userddssilva.phonebookbyme.R
import br.com.userddssilva.phonebookbyme.model.Contact
import br.com.userddssilva.phonebookbyme.view.EditContact
import com.google.gson.Gson

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
            val tvContactImage = findViewById<ImageView>(R.id.ivContactImage)

            tvContactName.text = item.name
            tvContactPhone.text = item.phone
            tvContactImage.setImageResource(R.drawable.profile_image)

            itemView.setOnClickListener {
                openEditContactActivity(item)
            }
        }

        private fun openEditContactActivity(item: Contact) {
            val intent = Intent(itemView.context, EditContact::class.java)
            val itemJson = Gson().toJson(item)
            intent.putExtra("contact", itemJson)
            itemView.context.startActivity(intent)
        }
    }
}