package com.example.crytpolistca.feature_currency_info.presentation.currency_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.crytpolistca.R
import com.example.crytpolistca.databinding.FragmentCurrencyListBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CurrencyListFragment : Fragment(R.layout.fragment_currency_list) {

    private val viewModel by sharedViewModel<CurrencyListViewModel>()

    private lateinit var binding: FragmentCurrencyListBinding
    private lateinit var adapter: CurrencyListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate view and obtain an instance of the binding class
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_currency_list,
                container,
                false
            )

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRvAdapter()

        setupObserver()
    }

    private fun setupRvAdapter() {
        adapter = CurrencyListAdapter()

        adapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
            override fun onChanged() {
                binding.currencyInfoRv.scrollToPosition(0)
            }

            override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
                binding.currencyInfoRv.scrollToPosition(0)
            }

            override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
                binding.currencyInfoRv.scrollToPosition(0)
            }

            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                binding.currencyInfoRv.scrollToPosition(0)
            }

            override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
                binding.currencyInfoRv.scrollToPosition(0)
            }

            override fun onItemRangeChanged(positionStart: Int, itemCount: Int, payload: Any?) {
                binding.currencyInfoRv.scrollToPosition(0)
            }
        })

        binding.currencyInfoRv.adapter = adapter
    }

    private fun setupObserver() {
        viewModel.currencyInfoLD.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                binding.emptyListTv.visibility = View.GONE
            } else {
                binding.emptyListTv.visibility = View.VISIBLE
            }

            adapter.submitList(it)
        }
    }

}