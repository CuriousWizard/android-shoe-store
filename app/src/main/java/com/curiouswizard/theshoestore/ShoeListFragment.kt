package com.curiouswizard.theshoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.curiouswizard.theshoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        setHasOptionsMenu(true)

        val viewModel: ActivityViewModel by activityViewModels()
        viewModel.onboardingDone()

        for(item in viewModel.shoes.value!!){
            binding.listContainer.addView(viewModel.createViewForItems(inflater.context, item))
        }

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.logout){
            NavigationUI.navigateUp(findNavController(), AppBarConfiguration(findNavController().graph))
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}