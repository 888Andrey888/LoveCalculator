package com.example.lovecalculator.ui.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator.databinding.ItemOnboardingBinding
import com.example.lovecalculator.loadImage
import com.example.lovecalculator.model.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit): Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf(
        OnBoarding(
            "Love is",
            "celebrate spring together.",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNI-SmMCG7Op4cLfqdof5MfA72b95aHqhb9Q&usqp=CAU"
        ),
        OnBoarding(
            "Love is",
            "when you don't ask the price of her new dress.",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRoApOIqfr2Lr51c5uQfPE063js0Oqou0pWnKl4ae0_JI_xIKyRn8oKbm8zacv17fGi3_M&usqp=CAU"
        ),
        OnBoarding(
            "Love is",
            "when his picture is on your table, and your love lives in his heart.",
            "https://flytothesky.ru/wp-content/uploads/2021/02/1-75.jpg"
        ),
        OnBoarding(
            "Love is",
            "rush home, knowing that your loved one is waiting for you there.",
            "https://memepedia.ru/wp-content/uploads/2018/02/%D0%BB%D0%B0%D0%B2-%D0%B8%D0%B7.jpg"
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
        fun bind(onBoarding: OnBoarding) = with(binding){
            tvTitle.text = onBoarding.title
            tvDesc.text = onBoarding.desc
            onBoarding.image?.let { imgBoard.loadImage(it) }
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