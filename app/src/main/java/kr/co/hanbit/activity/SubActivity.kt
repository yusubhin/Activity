package kr.co.hanbit.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.hanbit.activity.databinding.ActivityMainBinding
import kr.co.hanbit.activity.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    val binding by lazy { ActivitySubBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /* 메인 액티비티로부터 전달받은 인텐트에서 값 꺼내기 */
        binding.to1.text = intent.getStringExtra("from1")
        binding.to2.text = "${intent.getIntExtra("from2", 0)}"

        /* 메인 액티비티로 값 돌려주기 */
        binding.btnClose.setOnClickListener {
            val returnIntent = Intent() //메인 액티비티에 돌려줄 인텐트 생성하고 변수에 저장(돌려줄 때는 대상을 지정하지 않아도 되므로 Intent 안에는 아무 것도 담지 않음)
            returnIntent.putExtra("returnValue", binding.editMessage.text.toString())
            setResult(RESULT_OK, returnIntent) //상태값은 RESULT_OK와 RESULT_CANCELED로 안드로이드에 이미 상수로 정의되어 있음
            finish() //서브 액티비티가 종료되면서 메인 액티비티에 값이 전달됨
        }
    }
}