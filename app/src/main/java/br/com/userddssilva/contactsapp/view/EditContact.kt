package br.com.userddssilva.contactsapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.userddssilva.contactsapp.R
import br.com.userddssilva.contactsapp.model.Contact
import br.com.userddssilva.contactsapp.utils.Constants.CONTACT_INTENT
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson

class EditContact : AppCompatActivity() {

    private lateinit var tiName: TextInputEditText
    private lateinit var tiPhone: TextInputEditText
    private lateinit var tiAddress: TextInputEditText
    private lateinit var tiCity: TextInputEditText
    private lateinit var tiState: TextInputEditText
    private lateinit var tiZip: TextInputEditText
    private lateinit var tiEmail: TextInputEditText
    private lateinit var tiBirthday: TextInputEditText
    private lateinit var btnSave: MaterialButton
    private lateinit var contact: Contact

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_edit_contact)
        initPropertiesWithUIComponents()
        loadContactFromIntentJson()
        btnSave.text = getString(R.string.Save)
    }

    private fun initPropertiesWithUIComponents() {
        title = getString(R.string.title_edit_contact)
        tiName = findViewById(R.id.tiName)
        tiPhone = findViewById(R.id.tiPhone)
        tiAddress = findViewById(R.id.tiAddress)
        tiCity = findViewById(R.id.tiCity)
        tiState = findViewById(R.id.tiState)
        tiZip = findViewById(R.id.tiZip)
        tiEmail = findViewById(R.id.tiEmail)
        tiBirthday = findViewById(R.id.tiBirthday)
        btnSave = findViewById(R.id.btnConfirm)
    }

    private fun loadContactFromIntentJson() {
        val contactJson = intent.getStringExtra(CONTACT_INTENT)
        contact = Gson().fromJson(contactJson, Contact::class.java)
        contact.also {
            tiName.setText(it.name)
            tiPhone.setText(it.phone)
            tiEmail.setText(it.email)
        }
    }
}