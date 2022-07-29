package kr.co.hanbit.activity

import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kr.co.hanbit.activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /* onActivityResult의 대안(안전성 문제) */
        val activityResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                /* 서브 액티비티에서 돌려받은 resultCode가 정상인지 체크 */
                if (it.resultCode == RESULT_OK) {
                    val message =
                        it.data?.getStringExtra("returnValue") //정상이라면 돌려받은 인텐트에서 메세지를 꺼내 변수에 저장
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                    /* Toast: 화면에 잠깐 나타났다 사라지는 메시지 출력 도구
                    파라미터 1: 화면을 위한 기본 도구인 컨텍스트가 필요한데, 액티비티가 이미 가지고있음
                    파라미터 2: 출력될 메시지를 문자열로 전달
                    파라미터 3: 메시지가 얼마 동안 출력될 지를 결정 (LENGTH_LONG과 LENGTH_SHORT 두 가지로 여기서는 메시지 확인을 위해 오랫동안 출력되는 LENGTH_LONG 선택)
                 */
                }
            }

        /* 인텐트에 실행 메세지 전달하기 */
        val intent = Intent(this, SubActivity::class.java) //인텐트 생성 (this: MainActivity)

        /* 액티비티 사이에 값 주고 받기 */
        intent.putExtra("from1", "Hello Bundle") //파라미터 1: key, 파라미터 2: value
        intent.putExtra("from2", 2021)

        //binding.btnStart.setOnClickListener{ startActivity(intent) } //인텐트를 값으로 넘겨줌으로써 액티비티 실행
        /* statActivity() 메서드로 실행된 액티비티에서는 값을 돌려받을 수 없어 값을 전달받지 못하는 문제 발생 */
        binding.btnStart.setOnClickListener { activityResult.launch(intent) }
        /* 메인 액티비티에서 서브 액티비티를 호출한 후 값을 돌려받고 싶을 때는 activityResult 변수의 launch() 메서드를 사용해야함 */
    }
}