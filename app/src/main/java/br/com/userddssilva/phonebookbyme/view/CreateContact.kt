package br.com.userddssilva.phonebookbyme.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.userddssilva.phonebookbyme.R

class CreateContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_contact)
        title = getString(R.string.title_create_contact)

    }
}