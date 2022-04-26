package edu.wccnet.csherbenou.contactsapp

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactsRepository(application: Application) {

    val searchResults = MutableLiveData<List<Contact>>()
    private var contactsDao: ContactsDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContacts: LiveData<List<Contact>>?

    init {
        val db: ContactsRoomDatabase? =  ContactsRoomDatabase.getDatabase(application)
        contactsDao = db?.contactsDao()
        allContacts = contactsDao?.displayAllContacts()
    }

    fun insertContact(newContact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newContact)
        }
    }

    private suspend fun asyncInsert(contact: Contact) {
        contactsDao?.insertContact(contact)
    }

    fun deleteContact(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(id)
        }
    }

    private suspend fun asyncDelete(id: Int) {
        contactsDao?.deleteContact(id)
    }

    fun findContact(name: String) {

        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }

    private suspend fun asyncFind(name: String): Deferred<List<Contact>?> =

        coroutineScope.async(Dispatchers.IO) {
            return@async contactsDao?.findContact(name)
        }

    fun sortAsc(){

        coroutineScope.launch(Dispatchers.Main){
            searchResults.value = asyncAsc().await()
        }
    }

    private suspend fun asyncAsc(): Deferred<List<Contact>?> =

        coroutineScope.async(Dispatchers.IO) {
            return@async contactsDao?.sortAsc()
        }

    fun sortDesc(){

        coroutineScope.launch(Dispatchers.Main){
            searchResults.value = asyncDesc().await()
        }

    }

    private suspend fun asyncDesc(): Deferred<List<Contact>?> =

        coroutineScope.async(Dispatchers.IO) {
            return@async contactsDao?.sortDesc()
        }

}
