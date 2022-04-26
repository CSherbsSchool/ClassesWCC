package edu.wccnet.csherbenou.contactsapp.ui.main

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
//import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import edu.wccnet.csherbenou.contactsapp.Contact
import edu.wccnet.csherbenou.contactsapp.R
import edu.wccnet.csherbenou.contactsapp.databinding.MainFragmentBinding
import java.util.*


class MainFragment : Fragment() {


    private var adapter: ContactRecycleAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    //private lateinit var viewModel: MainViewModel
    private val viewModel: MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        listenerSetup()
        observerSetup()
        recyclerSetup()
    }

    private fun listenerSetup() {

        binding.Add.setOnClickListener {
            val name = binding.contactName.text.toString()
            val number = binding.contactNumber.text.toString()

            if (name != "" && number != "") {
                val contact = Contact(name, number)
                viewModel.insertContact(contact)
                clearFields()
            } else {
                Toast.makeText(activity, "Incomplete information", Toast.LENGTH_LONG).show()
            }
        }

        binding.Find.setOnClickListener { viewModel.findContact(binding.contactName.text.toString()) }

        binding.Asc.setOnClickListener { viewModel.sortAsc() }

        binding.Desc.setOnClickListener { viewModel.sortDesc() }

        //binding.recyclerView.hiddenID.setOnClickListener {
         //   viewModel.deleteContact(binding.main.recyclerView.hiddenID.text.toString())
        //    clearFields()
       // }
    }

    private fun observerSetup() {

        viewModel.displayAllContacts()?.observe(viewLifecycleOwner, androidx.lifecycle.Observer { contacts ->
            contacts?.let  {
                adapter?.setContactList(it)
            }
        })


        viewModel.getSearchResults().observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {
                    binding.contactName.setText(it[0].contactName)
                    binding.contactNumber.setText(it[0].contactNumber)
                } else {
                    var error = "No Match"
                    binding.contactName.text = Editable.Factory.getInstance().newEditable(error)
                }
            }
        })
    }

    private fun recyclerSetup() {
        adapter = ContactRecycleAdapter(R.layout.card_layout)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    private fun clearFields() {
        binding.contactName.setText("")
        binding.contactNumber.setText("")
    }

}