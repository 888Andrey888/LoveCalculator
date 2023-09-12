package com.example.lovecalculator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.Presenter
import com.example.lovecalculator.R
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.databinding.FragmentMainBinding
import com.example.lovecalculator.model.Pref
import com.example.lovecalculator.view.LoveView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment(), LoveView {

    private lateinit var binding: FragmentMainBinding

    @Inject
    lateinit var presenter: Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        presenter.showOnBoarding()
        initListener()
    }

    private fun initListener() = with(binding) {
        btnCalculate.setOnClickListener {
            presenter.getLoveResult(etFirst.text.toString(), etSecond.text.toString())
        }
    }

    override fun navigationToResult(loveModel: LoveModel) {
        findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToSecondFragment(
                loveModel
            )
        )
    }

    override fun navigationToOnBoarding() {
        findNavController().navigate(R.id.onBoardingFragment)
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}