package com.example.m5w2.fragment.onBoard

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.m5w2.R
import com.example.m5w2.databinding.FragmentOnBoardBinding
import com.example.m5w2.utils.PreferenceHelper
import com.example.m5w2.view_model.OnBoardViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardFragment : Fragment() {

    @Inject
    lateinit var sharedPreferences: PreferenceHelper
    private val binding by lazy { FragmentOnBoardBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupOnboardingScreens()
        setupListeners()
    }

    private fun setupOnboardingScreens() {
        binding.viewPager2.adapter = OnBoardViewPagerAdapter(this)
    }

    private fun setupListeners() = with(binding) {
        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 3) {
                    binding.tvSend.visibility = View.INVISIBLE
                    binding.btnStart.visibility = View.VISIBLE
                } else {
                    binding.tvSend.visibility = View.VISIBLE
                    binding.btnStart.visibility = View.INVISIBLE
                }
            }
        })

        binding.tvSend.setOnClickListener {
            completeOnBoarding()
        }

        binding.btnStart.setOnClickListener {
            completeOnBoarding()
        }
    }
    private fun completeOnBoarding() {
        sharedPreferences.isOnBoardShown = true
        findNavController().navigate(R.id.action_onBoardFragment_to_registerFragment)
    }
}