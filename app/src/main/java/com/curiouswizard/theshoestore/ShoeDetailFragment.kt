package com.curiouswizard.theshoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.curiouswizard.theshoestore.databinding.FragmentShoeDetailBinding
import com.google.android.material.snackbar.Snackbar

class ShoeDetailFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetailBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        val sharedViewModel: ActivityViewModel by activityViewModels()

        binding.buttonSave.setOnClickListener {
            if (binding.nameEditText.text.toString() != "" || binding.sizeEditText.text.toString() != "" ||
                binding.companyEditText.text.toString() != "" || binding.descriptionEditText.text.toString() != "") {
                    sharedViewModel.addShoe(
                        binding.nameEditText.text.toString(),
                        binding.sizeEditText.text.toString().toDouble(),
                        binding.companyEditText.text.toString(),
                        binding.descriptionEditText.text.toString()
                    )
                findNavController().navigateUp()
            }
            else{
                Snackbar.make(requireView(),R.string.empty_details, Snackbar.LENGTH_SHORT)
                        .setAnchorView(R.id.button_save)
                        .show()
            }
        }
        binding.buttonCancel.setOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }
}