package com.curiouswizard.theshoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.curiouswizard.theshoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        val sharedViewModel: ActivityViewModel by activityViewModels()

        binding.buttonSignIn.setOnClickListener {
            if(sharedViewModel.onboarding.value == true)
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            else
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToShoeListFragment())
        }
        binding.buttonCreateNewLogin.setOnClickListener {
            if(sharedViewModel.onboarding.value == true)
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            else
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToShoeListFragment())
        }

        return binding.root
    }
}