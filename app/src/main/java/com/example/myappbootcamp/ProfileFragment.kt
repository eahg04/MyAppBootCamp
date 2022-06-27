package com.example.myappbootcamp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myappbootcamp.adapter.OptionsAdapter
import com.example.myappbootcamp.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private var options: OptionsAdapter? = null
    private var listOptions = OptionsProvider

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        showOptions(listOptions.optionsList)
    }

    private fun showOptions(listOptions: List<Options>) {
        options = OptionsAdapter(listOptions) {
        }
        binding.recyclerContent.adapter=options
    }
}
