package com.example.mydashboard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.mydashboard.databinding.FragmentLogInBinding
import kotlin.concurrent.fixedRateTimer


class LogInFragment : Fragment(R.layout.fragment_log_in), OnSwitchToFragment {

    private var _binding: FragmentLogInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("CommitTransaction")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveButton.setOnClickListener {
            val user = User(binding.loginET.text.toString(), binding.passwordET.text.toString())

            val bundle = Bundle()
            bundle.putParcelable("user", user)
            val mainFragment = MainFragment()
            mainFragment.arguments = bundle
            binding.loginET.text.clear()
            binding.passwordET.text.clear()
            onSwitch(mainFragment)
        }
    }

    override fun onSwitch(fragment: Fragment) {
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragment_container, fragment)
        transaction?.addToBackStack(null)
        transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction?.commit()
    }

}