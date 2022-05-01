package com.mokhtar.sarytask.ui.splash

import android.app.ActivityOptions
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.mokhtar.sarytask.R
import com.mokhtar.sarytask.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_in)
        binding.root.startAnimation(animation)

        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) = Unit

            override fun onAnimationEnd(p0: Animation?) {
                val action = SplashFragmentDirections.actionSplashFragmentToStoreFragment()
                findNavController().navigate(action)
            }

            override fun onAnimationRepeat(p0: Animation?) = Unit
        })


        return binding.root
    }

    companion object {
        private const val TAG = "SplashFragment"
    }
}