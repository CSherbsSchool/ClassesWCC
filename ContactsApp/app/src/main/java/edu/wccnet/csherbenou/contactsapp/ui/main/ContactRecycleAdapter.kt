package edu.wccnet.csherbenou.contactsapp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import edu.wccnet.csherbenou.contactsapp.Contact
import edu.wccnet.csherbenou.contactsapp.R

class ContactRecycleAdapter(private val contactItemList: Int) : RecyclerView.Adapter<ContactRecycleAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }



    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        viewHolder.contactId.text = contactList!![i].id.toString()
        viewHolder.displayName.text = contactList!![i].contactName
        viewHolder.displayNumber.text = contactList!![i].contactNumber

       // viewHolder.itemView.setOnClickListener {
        //    fun onClick(id: Int) {
       //         MainViewModel.deleteContact(id)
         //   }
       // }
    }

    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var contactId: TextView
        var displayName: TextView
        var displayNumber: TextView

        init {
            contactId = itemView.findViewById(R.id.hiddenID)
            displayName = itemView.findViewById(R.id.displayName)
            displayNumber = itemView.findViewById(R.id.displayNumber)

        }
    }



}