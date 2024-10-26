package com.example.m5w2.fragment.onBoard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.m5w2.R
import com.example.m5w2.databinding.FragmentOnBoardPagingBinding

class OnBoardPagingFragment : Fragment() {

    private val binding by lazy { FragmentOnBoardPagingBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPageContent()
    }

    private fun setupPageContent() {
        val position = arguments?.getInt(ARG_ONBOARD_POSITION) ?: 0
        when (position) {
            0 -> {
                binding.txtTitle.text = "Удобство"
                binding.desc.text = "Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи мгновенно."
                Glide.with(binding.imgTitle).load(R.mipmap.ic_launcher).into(binding.imgTitle)
            }
            1 -> {
                binding.txtTitle.text = "Организация"
                binding.desc.text = "Организуйте заметки по папкам и тегам. Легко находите нужную информацию."
                Glide.with(binding.imgTitle).load(R.mipmap.ic_launcher).into(binding.imgTitle)
            }
            2 -> {
                binding.txtTitle.text = "Синхронизация"
                binding.desc.text = "Синхронизируйте на всех устройствах. Доступ к заметкам в любое время."
                Glide.with(binding.imgTitle).load(R.mipmap.ic_launcher).into(binding.imgTitle)
            }
            3 -> {
                binding.txtTitle.text = "Безопасность"
                binding.desc.text = "Ваши данные надежно защищены. Только вы имеете к ним доступ."
                Glide.with(binding.imgTitle).load(R.mipmap.ic_launcher).into(binding.imgTitle)
            }
        }
    }

    companion object {
        private const val ARG_ONBOARD_POSITION = "onboard_position"

        fun newInstance(position: Int): OnBoardPagingFragment {
            return OnBoardPagingFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ONBOARD_POSITION, position)
                }
            }
        }
    }
}