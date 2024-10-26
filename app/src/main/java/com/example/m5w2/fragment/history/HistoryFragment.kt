package com.example.m5w2.fragment.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.m5w2.databinding.FragmentHistoryBinding
import com.example.m5w2.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvHistory.layoutManager = LinearLayoutManager(requireContext())
        viewModel.historyData.observe(viewLifecycleOwner) { history ->
            binding.rvHistory.adapter = LoveHistoryAdapter(history)
        }
        val firstName = "Alice"
        val secondName = "Bob"
        viewModel.fetchPercentageAndSave(firstName, secondName)
    }
}