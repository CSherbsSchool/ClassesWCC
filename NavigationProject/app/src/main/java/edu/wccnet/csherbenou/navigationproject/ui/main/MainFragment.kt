package edu.wccnet.csherbenou.navigationproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import edu.wccnet.csherbenou.navigationproject.R
import edu.wccnet.csherbenou.navigationproject.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        //return inflater.inflate(R.layout.main_fragment, container, false)
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.button1.setOnClickListener {
            //Navigation.findNavController(it).navigate(
            //R.id.action_mainFragment_to_secondFragment
            //)
            val action1: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond ()
            action1.setMessage(binding.textImage1.text.toString())
            action1.image = R.drawable.android_image_1
            Navigation.findNavController(it).navigate(action1)
        }

        binding.button2.setOnClickListener {
            val action2: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond ()
            action2.setMessage(binding.textImage2.text.toString())
            action2.image = R.drawable.android_image_2
            Navigation.findNavController(it).navigate(action2)

        }

        binding.button3.setOnClickListener {
            val action3: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond ()
            action3.setMessage(binding.textImage3.text.toString())
            action3.image = R.drawable.android_image_3
            Navigation.findNavController(it).navigate(action3)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}