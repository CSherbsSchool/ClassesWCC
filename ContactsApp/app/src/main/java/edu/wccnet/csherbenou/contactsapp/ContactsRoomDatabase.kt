package edu.wccnet.csherbenou.contactsapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Contact::class)], version = 1)
abstract class ContactsRoomDatabase: RoomDatabase() {

    abstract fun contactsDao(): ContactsDao

    companion object {

        private var INSTANCE: ContactsRoomDatabase? = null

        internal fun getDatabase(context: Context): ContactsRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(ContactsRoomDatabase::class.java) {
                    if (INSTANCE == null) INSTANCE =
                        Room.databaseBuilder<ContactsRoomDatabase>(
                            context.applicationContext,
                            ContactsRoomDatabase::class.java,
                            "contact_database").build()
                }
            }
            return INSTANCE
        }
    }
}