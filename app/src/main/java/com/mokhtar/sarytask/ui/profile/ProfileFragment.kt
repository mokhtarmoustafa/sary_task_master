package com.mokhtar.sarytask.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mokhtar.sarytask.R
import com.mokhtar.sarytask.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    //region variables
    private lateinit var binding: FragmentProfileBinding

    //endregion
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lLanguage.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_bottomSheet)
        }
    }

    companion object {
        private const val TAG = "ProfileFragment"
    }
}