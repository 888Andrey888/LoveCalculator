package com.example.lovecalculator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculator.ResultPresenter
import com.example.lovecalculator.databinding.FragmentSecondBinding
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.view.ResultView

class SecondFragment : Fragment(), ResultView {

    private lateinit var binding: FragmentSecondBinding
    private val presenter = ResultPresenter(this)
    //private lateinit var navArgs: SecondFragmentArgs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        arguments?.let {
            val navArgs = SecondFragmentArgs.fromBundle(it)
            presenter.getData(navArgs.loveModel)
        }
    }

    override fun showLove(
        firstName: String,
        secondName: String,
        percentage: String,
        result: String
    ) {
        with(binding) {
            tvFirst.text = firstName
            tvSecond.text = secondName
            tvPercentage.text = percentage
            tvResult.text = result
        }
    }
}