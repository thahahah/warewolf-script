package com.example.warewolf_script;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backKeyPressedTime = 0;
    public Button button, reset;
    public RadioButton Doppelganger, warewolf, minion, freemason, seer, robber, troublemaker, drunk, insomniac;
    public int dp, w, m, free, se, rob, tb, dr, inso = 0;
    int min = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Doppelganger = findViewById(R.id.Doppelganger);
        warewolf = findViewById(R.id.warewolf);
        minion = findViewById(R.id.minion);
        freemason = findViewById(R.id.freemason);
        seer = findViewById(R.id.seer);
        robber = findViewById(R.id.robber);
        troublemaker = findViewById(R.id.troublemaker);
        drunk = findViewById(R.id.drunk);
        insomniac = findViewById(R.id.insomniac);
        button = findViewById(R.id.btn_finish);
        reset = findViewById(R.id.reset);

        //초기화
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();//인텐트 종료
                Intent intent = getIntent(); //인텐트
                startActivity(intent); //액티비티 열기
                overridePendingTransition(0, 0);//인텐트 효과 없애기
            }
        });

        //시작
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Doppelganger.isChecked()){
                    dp = 1;
                    min += 1;
                }
                if(warewolf.isChecked()){
                    w = 1;
                    min += 1;
                }
                if(minion.isChecked()){
                    m = 1;
                    min += 1;
                }
                if(freemason.isChecked()){
                    free = 1;
                    min += 1;
                }
                if(seer.isChecked()){
                    se = 1;
                    min += 1;
                }
                if(robber.isChecked()){
                    rob = 1;
                    min += 1;
                }
                if(troublemaker.isChecked()){
                    tb = 1;
                    min += 1;
                }
                if(drunk.isChecked()){
                    dr = 1;
                    min += 1;
                }
                if(insomniac.isChecked()){
                    inso = 1;
                    min += 1;
                }
                if(min < 3){
                    Toast.makeText(getApplicationContext(), "직업은 최소 3개 이상을 선택해주세요.", Toast.LENGTH_SHORT).show();
                    finish();//인텐트 종료
                    overridePendingTransition(0, 0);//인텐트 효과 없애기
                    Intent intent = getIntent(); //인텐트
                    startActivity(intent); //액티비티 열기
                    overridePendingTransition(0, 0);//인텐트 효과 없애기
                }
                if(min >= 3){
                    Intent intent = new Intent(MainActivity.this, MainScript.class);
                    intent.putExtra("dp",dp);
                    intent.putExtra("w",w);
                    intent.putExtra("m",m);
                    intent.putExtra("free",free);
                    intent.putExtra("se",se);
                    intent.putExtra("rob",rob);
                    intent.putExtra("tb",tb);
                    intent.putExtra("dr",dr);
                    intent.putExtra("inso",inso);
                    startActivity(intent);
                    overridePendingTransition(0, 0);//인텐트 효과 없애기

                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        // 뒤로가기 버튼 2번 누를 시 종료
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다. ", Toast.LENGTH_SHORT).show();
            return;
        }

        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            // 앱 완전 종료 코드
            ActivityCompat.finishAffinity(this);
            System.exit(0);
        }

    }
}