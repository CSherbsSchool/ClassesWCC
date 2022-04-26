package edu.wccnet.csherbenou.contactsapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactsDao {

    @Insert
    fun insertContact(contact: Contact)

    @Query("SELECT * FROM contacts WHERE contactName LIKE '%' || :contactName || '%'")
    fun findContact(contactName: String): List<Contact>

    @Query("DELETE FROM contacts WHERE contactId = :id")
    fun deleteContact(id: Int)

    @Query("SELECT * FROM contacts")
    fun displayAllContacts(): LiveData<List<Contact>>

//THIS DOES THE ASC SORT FROM THE DATABASE
    @Query("SELECT * FROM contacts ORDER BY contactName ASC")
    fun sortAsc(): List<Contact>

//THIS DOES THE DESC SORT FROM THE DATABASE
    @Query("SELECT * FROM contacts ORDER BY contactName DESC")
    fun sortDesc(): List<Contact>

}