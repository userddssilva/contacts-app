package br.com.userddssilva.contactsapp.model

data class Contact(
    var name: String,
    var phone: String? = null,
    var address: String? = null,
    var city: String? = null,
    var state: String? = null,
    var zip: String? = null,
    var email: String? = null,
    var birthday: String? = null
)