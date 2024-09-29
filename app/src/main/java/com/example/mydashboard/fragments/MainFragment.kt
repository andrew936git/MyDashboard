package com.example.mydashboard.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.mydashboard.OnSwitchToFragment
import com.example.mydashboard.R
import com.example.mydashboard.databinding.FragmentMainBinding
import com.example.mydashboard.room.User


class MainFragment : Fragment(R.layout.fragment_main), OnSwitchToFragment {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("CommitTransaction")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = arguments?.getParcelable<User>("user")

        binding.logInCV.setOnClickListener {
            onSwitch(LogInFragment())
        }

        binding.galleryCV.setOnClickListener {
            onSwitch(GalleryFragment())
        }

        binding.listCV.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("newUser", user)
            val listFragment = ListFragment()
            listFragment.arguments = bundle
            onSwitch(listFragment)
        }

        binding.exitCV.setOnClickListener{
            activity?.finishAffinity()
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