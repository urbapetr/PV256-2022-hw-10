package cz.muni.fi.pv256.hw10.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cz.muni.fi.pv256.hw10.R
import cz.muni.fi.pv256.hw10.data.NamedApiResource
import cz.muni.fi.pv256.hw10.databinding.MainFragmentBinding
import cz.muni.fi.pv256.hw10.repo.Result
import cz.muni.fi.pv256.hw10.ui.detail.DetailActivity
import cz.muni.fi.pv256.hw10.ui.detail.DetailActivity.Companion.ITEM

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MainAdapter
    private val viewModel: MainViewModel by viewModels()

    private var pageNo = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // tod
        adapter = MainAdapter(binding.switcher) { namedApiResource -> adapterOnClick(namedApiResource) }
        binding.recyclerView.apply {
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            adapter = this@MainFragment.adapter
        }

        viewModel.items.observe(
            viewLifecycleOwner,
            {
                handleResult(it)
            }
        )

        viewModel.setPage(pageNo)

        binding.fab.setOnClickListener { fabOnClick() }
    }

    private fun handleResult(result: Result<List<NamedApiResource>>) {
        adapter.items = result.value ?: emptyList()
        when (result.state) {
            Result.State.LOADING ->
                binding.loading.show()
            Result.State.SUCCESS ->
                binding.loading.hide()
            Result.State.ERROR -> {
                binding.loading.hide()
                Toast.makeText(
                    context,
                    R.string.cannot_load,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun adapterOnClick(namedApiResource: NamedApiResource) {
        val intent = Intent(context, DetailActivity()::class.java)
        intent.putExtra(ITEM, namedApiResource.name)
        startActivity(intent)
    }

    private fun fabOnClick() {
        viewModel.setPage(pageNo)
    }
}
