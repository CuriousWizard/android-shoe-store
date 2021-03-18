package com.curiouswizard.theshoestore

import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curiouswizard.theshoestore.model.Shoe

class ActivityViewModel : ViewModel() {
    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    private val _onboarding = MutableLiveData<Boolean>()
    val onboarding: LiveData<Boolean>
        get() = _onboarding

    init {
        _shoes.value = mutableListOf(
                Shoe("Revolution 5", 41.0, "Nike", "For spring/summer, lightweight"),
                Shoe("Twin Serve", 41.0, "Lacoste", "Cool shoes for the upcoming Spring/Summer season")
        )
        _onboarding.value = true
    }

    fun addShoe(name: String = "", size: Double = 0.0, company: String = "", description: String = "") {
        _shoes.value?.add(Shoe(name, size, company, description))
    }

    fun onboardingDone() {
        _onboarding.value = false
    }

    fun createViewForItems(context: Context, item: Shoe): TextView {
        val myTextView = TextView(context)
        myTextView.layoutParams =
                ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT)
        myTextView.text = (item.company + " - " + item.name)
        myTextView.textSize = 30F
        return myTextView
    }
}