package com.example.lovecalculator.ui.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemOnboardingBinding
import com.example.lovecalculator.loadImage
import com.example.lovecalculator.model.OnBoardingModel

class OnBoardingAdapter(private val onClick: () -> Unit): Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf(
        OnBoardingModel(
            "Love is",
            "celebrate spring together.",
            R.raw.animation_lmgdsbop
        ),
        OnBoardingModel(
            "Love is",
            "when you don't ask the price of her new dress.",
            R.raw.animation_lmgdtfrc
            ),
        OnBoardingModel(
            "Love is",
            "when his picture is on your table, and your love lives in his heart.",
            R.raw.animation_lmgdtx62
        ),
        OnBoardingModel(
            "Love is",
            "rush home, knowing that your loved one is waiting for you there.",
            R.raw.animation_lmgdu1hr
        )
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding): ViewHolder(binding.root){
        fun bind(onBoardingModel: OnBoardingModel) = with(binding){
            tvTitle.text = onBoardingModel.title
            tvDesc.text = onBoardingModel.desc
            animationView.setAnimation(onBoardingModel.lottie)
            btnStart.isVisible = adapterPosition == data.lastIndex
            tvSkip.isVisible = adapterPosition != data.lastIndex
            btnStart.setOnClickListener {
                onClick()
            }
            tvSkip.setOnClickListener {
                onClick()
            }
        }
    }
}