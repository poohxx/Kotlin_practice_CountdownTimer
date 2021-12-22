package com.poohxx.kotlin_practice_countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.poohxx.kotlin_practice_countdowntimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var timer: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnStart.setOnClickListener{
                startCountdowmTimer(10000)
            }
            btnStop.setOnClickListener{
                stopCountdawnTimer()
            }
        }
    }
    private fun startCountdowmTimer(timeMillis: Long){
        timer?.cancel()
        timer = object : CountDownTimer(timeMillis, 1){
            override fun onTick(p0: Long) {
                binding.tvStatus.text = "Started"
                binding.tvCount.text = p0.toString()
            }

            override fun onFinish() {
                binding.tvStatus.text = "Finished"

            }

        }.start()

    }
    private fun stopCountdawnTimer(){
        timer!!.cancel()
        binding.tvStatus.text = "Stoped"

    }
}