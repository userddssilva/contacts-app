package br.com.userddssilva.contactsapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.userddssilva.contactsapp.R
import br.com.userddssilva.contactsapp.model.Contact
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class CreateContact : AppCompatActivity() {

    private lateinit var btnCreateContact: MaterialButton
    private lateinit var tiName: TextInputEditText
    private lateinit var tiPhone: TextInputEditText
    private lateinit var tiAddress: TextInputEditText
    private lateinit var tiCity: TextInputEditText
    private lateinit var tiState: TextInputEditText
    private lateinit var tiZip: TextInputEditText
    private lateinit var tiEmail: TextInputEditText
    private lateinit var tiBirthday: TextInputEditText
    private lateinit var contact: Contact

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_contact)
        initPropertiesWithUIComponents()
        createNewContact()
    }

    private fun createNewContact() {
        btnCreateContact.setOnClickListener {
            contact.also {
                it.name = tiName.text.toString()
                it.phone = tiPhone.text.toString()
                it.address = tiAddress.text.toString()
                it.city = tiCity.text.toString()
                it.state = tiState.text.toString()
                it.zip = tiZip.text.toString()
                it.email = tiEmail.text.toString()
                it.birthday = tiBirthday.text.toString()
            }
        }
    }

    private fun initPropertiesWithUIComponents() {
        title = getString(R.string.title_create_contact)
        tiName = findViewById(R.id.tiName)
        tiPhone = findViewById(R.id.tiPhone)
        tiAddress = findViewById(R.id.tiAddress)
        tiCity = findViewById(R.id.tiCity)
        tiState = findViewById(R.id.tiState)
        tiZip = findViewById(R.id.tiZip)
        tiEmail = findViewById(R.id.tiEmail)
        tiBirthday = findViewById(R.id.tiBirthday)
        btnCreateContact = findViewById(R.id.btnCreateContact)
    }
}