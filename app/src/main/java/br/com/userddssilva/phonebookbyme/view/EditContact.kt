package br.com.userddssilva.phonebookbyme.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.userddssilva.phonebookbyme.R
import br.com.userddssilva.phonebookbyme.model.Contact
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson

class EditContact : AppCompatActivity() {

    private lateinit var tiName: TextInputEditText
    private lateinit var tiPhone: TextInputEditText
    private lateinit var tiAdress: TextInputEditText
    private lateinit var tiCity: TextInputEditText
    private lateinit var tiState: TextInputEditText
    private lateinit var tiZip: TextInputEditText
    private lateinit var tiEmail: TextInputEditText
    private lateinit var tiBirthday: TextInputEditText
    private lateinit var contact: Contact

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_contact)
        title = getString(R.string.title_edit_contact)

        tiName = findViewById(R.id.tiName)
        tiPhone = findViewById(R.id.tiPhone)
        tiAdress = findViewById(R.id.tiAddress)
        tiCity = findViewById(R.id.tiCity)
        tiState = findViewById(R.id.tiState)
        tiZip = findViewById(R.id.tiZip)
        tiEmail = findViewById(R.id.tiEmail)
        tiBirthday = findViewById(R.id.tiBirthday)

        loadContact()
    }

    private fun loadContact() {
        val contactJson = intent.getStringExtra("contact")
        contact = Gson().fromJson(contactJson, Contact::class.java)

        contact.let {
            tiName.setText(it.name)
            tiPhone.setText(it.phone)
            tiEmail.setText(it.email)
        }
    }
}