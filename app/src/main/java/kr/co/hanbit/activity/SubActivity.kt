package kr.co.hanbit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.hanbit.activity.databinding.ActivityMainBinding
import kr.co.hanbit.activity.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    val binding by lazy { ActivitySubBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.to1.text = intent.getStringExtra("from1")
        binding.to2.text = "${intent.getIntExtra("from2", 0)}"
    }
}