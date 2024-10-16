package com.example.m5w2.fragment.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.m5w2.R
import com.example.m5w2.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private val binding by lazy {FragmentResultBinding.inflate(layoutInflater)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firstName = arguments?.getString("firstName")
        val secondName = arguments?.getString("secondName")
        val percentage = arguments?.getString("percentage")

        binding.firstName.text = firstName
        binding.secondName.text = secondName
        binding.percentage.text = "$percentage%"
    }
}