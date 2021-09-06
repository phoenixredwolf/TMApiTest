package com.example.tmapitest.ui.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tmapitest.R
import com.example.tmapitest.data.model.Page
import com.example.tmapitest.databinding.PageFragmentBinding
import com.example.tmapitest.ui.adapater.DataAdapter
import com.example.tmapitest.ui.viewvodel.PageViewModel
import com.example.tmapitest.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PageFragment : Fragment(R.layout.page_fragment) {

    private val viewModel by viewModels<PageViewModel>()
    private val adapter by lazy { DataAdapter() }
    private lateinit var binding: PageFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PageFragmentBinding.bind(view).apply { dataCardRv.adapter = adapter }
        viewModel.page.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it is Resource.Loading
            if (it is Resource.Success) fetchSuccess(it.data.page!!)
            if (it is Resource.Error) fetchFailure(it.errorMsg)
        }
    }

    private fun fetchSuccess(page: Page) {
        adapter.submitList(page.cards)
    }

    private fun fetchFailure(errorMsg: String) {
        Toast.makeText(requireContext(), errorMsg, Toast.LENGTH_LONG).show()
    }
}