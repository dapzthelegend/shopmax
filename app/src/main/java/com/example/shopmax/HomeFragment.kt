package com.example.shopmax

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopmax.data.ShipmentResponseShipments
import com.example.shopmax.databinding.FragmentHomeBinding
import com.example.shopmax.ui.HomeViewModel
import com.example.shopmax.ui.ShipmentAdapter
import com.example.shopmax.ui.ShipmentItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    private val viewModel:HomeViewModel by activityViewModels()
    private lateinit var shipmentAdapter:ShipmentAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(activity),
            R.layout.fragment_home,
            container,
            false
        )
        binding.lifecycleOwner = this
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeFields()
        viewModel.shipments.observe(viewLifecycleOwner, {
            shipmentAdapter.setList(it.data.shipments)
        })

    }

    private fun initializeFields() {
        shipmentAdapter = ShipmentAdapter { model ->
            onItemClicked(model)
        }

        home_shipments_recyclerview.layoutManager = LinearLayoutManager(activity)
        home_shipments_recyclerview.adapter = shipmentAdapter
        home_shipments_recyclerview.setHasFixedSize(true)
        home_shipments_recyclerview.addItemDecoration(ShipmentItemDecoration(20))
        home_get_quote_fab.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToQuoteFragment()
            it.findNavController().navigate(action)
        }

    }

    private fun onItemClicked(model: ShipmentResponseShipments) {
        val action = HomeFragmentDirections.actionHomeFragmentToTrackingFragment()

        view?.findNavController()?.navigate(action)



    }


}