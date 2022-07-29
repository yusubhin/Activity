package kr.co.hanbit.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.hanbit.activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, SubActivity::class.java) //인텐트 생성 (this: MainActivity)
        binding.btnStart.setOnClickListener{ startActivity(intent) } //인텐트를 값으로 넘겨줌으로써 액티비티 실행
    }
}