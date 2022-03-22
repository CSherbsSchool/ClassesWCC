package edu.wccnet.csherbenou.lifecycleproject2.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import edu.wccnet.csherbenou.lifecycleproject2.DemoObserver
import edu.wccnet.csherbenou.lifecycleproject2.R
import edu.wccnet.csherbenou.lifecycleproject2.databinding.MainFragmentBinding

import edu.wccnet.csherbenou.lifecycleproject2.BR.myViewModel

class MainFragment : Fragment() {


    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var binding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        //return inflater.inflate(R.layout.main_fragment, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.setLifecycleOwner(this)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.setVariable(myViewModel, viewModel)

        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        lifecycle.addObserver(DemoObserver())

    }


}