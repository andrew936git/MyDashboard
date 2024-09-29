package com.example.mydashboard

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydashboard.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = CustomAdapter(requireContext())
        binding.listView.adapter = adapter
        adapter.notifyDataSetChanged()

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        viewModel.users.observe(viewLifecycleOwner){list ->
            list?.let {
                adapter.updateList(it)
            }
        }

        val user = arguments?.getParcelable<User>("newUser")

        if (user != null) {
            viewModel.insertUser(user)
            val bundle = Bundle()

        }
}


}