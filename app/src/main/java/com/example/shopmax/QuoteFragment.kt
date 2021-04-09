package com.example.shopmax

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shopmax.databinding.FragmentQuoteBinding
import kotlinx.android.synthetic.main.fragment_quote.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuoteFragment : Fragment() {
    lateinit var binding:FragmentQuoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(LayoutInflater.from(activity),R.layout.fragment_quote, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initializeFields()

    }

    private fun initializeFields() {
        quotes_close_button.setOnClickListener {
         it.findNavController().popBackStack()
        }
    }


}