package com.tora.khabartimes.base

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.tora.khabartimes.R
import kotlinx.coroutines.launch


abstract class BaseFragment<BVM : BaseViewModel, DB : ViewDataBinding>(
    @LayoutRes val layout: Int
) : Fragment() {
    var binding: DB? = null


    private var progressBar: AlertDialog? = null

    abstract fun getViewModel(): BVM
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, layout, container, false)
        binding!!.lifecycleOwner = viewLifecycleOwner
        super.onCreateView(inflater, container, savedInstanceState)
        val viewModel = getViewModel()
        val view = layoutInflater.inflate(R.layout.lottie_anim, null)
        progressBar = AlertDialog.Builder(requireActivity()).create()
        progressBar!!.apply {
            setView(view)
            window?.setBackgroundDrawableResource(android.R.color.transparent)
            setCancelable(false)
        }

        viewModel.progressState.observe(viewLifecycleOwner, {
            if (it != 0) progressBar!!.show() else {
                progressBar!!.hide()
                progressBar!!.dismiss()
                progressBar!!.cancel()
            }

        })
        lifecycleScope.launch {
            viewModel.errorText.observe(viewLifecycleOwner, { content ->
                content.getContentIfNotHandled()
                    ?.let { text ->
                        // Only proceed if the event has never been handled
                        Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT)
                            .show()
                    }
            })
        }
        return binding!!.root
    }


    fun navigateWithDirection(navDirections: NavDirections) {
        Navigation.findNavController(binding!!.root).navigate(navDirections)
    }

    fun navigate(resId: Int) {
        Navigation.findNavController(binding!!.root).navigate(resId)
    }


    fun navigateUp() {
        NavHostFragment.findNavController(this).navigateUp()
    }

    fun hideKeyboard() {
        val inputMethodManager =
            requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding!!.root.windowToken, 0)
    }

    fun showKeyboard() {
        val imm =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm!!.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        androidAnim.removeAllListeners()
        progressBar!!.dismiss()
        progressBar = null
        binding = null
    }

}