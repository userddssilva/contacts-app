package br.com.userddssilva.phonebookbyme.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.userddssilva.phonebookbyme.R
import br.com.userddssilva.phonebookbyme.adapter.ContactAdapter
import br.com.userddssilva.phonebookbyme.model.Contact
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var rcContacts: RecyclerView
    private lateinit var fbtnAddNewContact: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcContacts = findViewById(R.id.rcContacts)
        fbtnAddNewContact = findViewById(R.id.fbtnAddNewContact)

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
        rcContacts.adapter = ContactAdapter(contacts)

        fbtnAddNewContact.setOnClickListener {
            startActivity(Intent(this, CreateContact::class.java))
        }

    }
}