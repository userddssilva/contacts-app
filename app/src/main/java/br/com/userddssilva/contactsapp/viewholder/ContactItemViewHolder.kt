package br.com.userddssilva.contactsapp.viewholder

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.userddssilva.contactsapp.R
import br.com.userddssilva.contactsapp.model.Contact
import br.com.userddssilva.contactsapp.utils.Constants
import br.com.userddssilva.contactsapp.view.EditContact
import com.google.gson.Gson

class ContactItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

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
        intent.putExtra(Constants.CONTACT_INTENT, itemJson)
        itemView.context.startActivity(intent)
    }
}