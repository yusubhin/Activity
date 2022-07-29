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

        /* 인텐트에 실행 메세지 전달하기 */
        val intent = Intent(this, SubActivity::class.java) //인텐트 생성 (this: MainActivity)

        /* 액티비티 사이에 값 주고 받기 */
        intent.putExtra("from1", "Hello Bundle") //파라미터 1: key, 파라미터 2: value
        intent.putExtra("from2", 2021)

        binding.btnStart.setOnClickListener{ startActivity(intent) } //인텐트를 값으로 넘겨줌으로써 액티비티 실행
    }
}