package com.example.lovecalculator.ui.history

import android.app.AlertDialog
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lovecalculator.HistoryPresenter
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentHistoryBinding
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.view.HistoryView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryFragment : Fragment(), HistoryView {

    private lateinit var binding: FragmentHistoryBinding
    private val adapter = HistoryAdapter(this::onClickItem, this::onLongClickItem)
    @Inject
    lateinit var historyPresenter: HistoryPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        historyPresenter.attachView(this)
        historyPresenter.getHistoryList()
    }

    private fun onClickItem(loveModel: LoveModel) {
        historyPresenter.getDate(loveModel)
    }

    private fun onLongClickItem(loveModel: LoveModel) {
        showDeleteDialog(loveModel)
    }

    override fun initRecyclerView(historyList: List<LoveModel>) {
        binding.rvHistory.adapter = adapter
        adapter.addLoveHistory(historyList)
    }

    override fun showDeleteDialog(loveModel: LoveModel) {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle(getString(R.string.delete))
            .setMessage(getString(R.string.delete_message)).setCancelable(true)
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                historyPresenter.deleteItem(loveModel)
            }.setNegativeButton(getString(R.string.no)) { _, _ -> }.show()
    }

    override fun showDateDialog(time: Long) {
        val alertDialog = AlertDialog.Builder(requireContext())

        Log.d("ololo", "showDateDialog: $time")

        alertDialog.setTitle(getString(R.string.date_of_creation))
            .setMessage(SimpleDateFormat("d MMM yyyy HH:mm:ss").format(time))
            .setNegativeButton(getString(R.string.close)) { _, _ -> }.show()
    }
}