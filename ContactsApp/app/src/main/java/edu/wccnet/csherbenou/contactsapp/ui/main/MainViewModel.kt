package edu.wccnet.csherbenou.contactsapp.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Query
import edu.wccnet.csherbenou.contactsapp.Contact
import edu.wccnet.csherbenou.contactsapp.ContactsRepository

class MainViewModel(application: Application) : AndroidViewModel(application){

    private val repository: ContactsRepository = ContactsRepository(application)
    private val allContacts: LiveData<List<Contact>>?
    private val searchResults: MutableLiveData<List<Contact>>


    init {
        allContacts = repository.allContacts
        searchResults = repository.searchResults
    }

    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
    }

    fun findContact(name: String) {
        repository.findContact(name)
    }

    fun deleteContact(id: Int) {
        repository.deleteContact(id)
    }

    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }

    fun displayAllContacts(): LiveData<List<Contact>>? {
        return allContacts
    }

    fun sortAsc(): MutableLiveData<List<Contact>> {
        repository.sortAsc()
        return searchResults
    }

    fun sortDesc(): MutableLiveData<List<Contact>>{
        repository.sortDesc()
        return searchResults
    }
}