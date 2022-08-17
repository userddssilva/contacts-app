package br.com.userddssilva.contactsapp.model

data class Contact(
    var name: String,
    val phone: String,
    val address: String,
    val city: String,
    val state: String,
    val zip: String,
    var email: String,
    val birthday: String
)