package br.com.userddssilva.contactsapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.userddssilva.contactsapp.R
import br.com.userddssilva.contactsapp.adapter.ContactListAdapter
import br.com.userddssilva.contactsapp.model.Contact
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var rcContacts: RecyclerView
    private lateinit var btnAddNewContact: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcContacts = findViewById(R.id.rcContacts)
        btnAddNewContact = findViewById(R.id.btnAddNewContact)

        val contact = Contact(
            name = "Dayvson",
            phone = "92 99999-9999",
            email = "loreipsum@gmail.com"
        )
        val contacts = mutableListOf<Contact>()
        for (i in 1..30) {
            contacts.add(contact)
        }
        val layoutManager = LinearLayoutManager(this)
        rcContacts.layoutManager =  layoutManager
        rcContacts.adapter = ContactListAdapter(contacts)

        btnAddNewContact.setOnClickListener {
            startActivity(Intent(this, CreateContact::class.java))
        }

    }
}