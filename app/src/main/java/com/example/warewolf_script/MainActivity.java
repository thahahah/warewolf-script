package com.example.warewolf_script;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backKeyPressedTime = 0;
    RadioGroup radioGroup;
    private RadioButton Doppelganger, warewolf, warewolf2, minion, freemason, seer, robber, troublemaker, drunk, insomniac;
    private Button button;
    boolean dp, w1, w2, m, free, se, rob, tb, dr, insom = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Doppelganger = findViewById(R.id.Doppelganger);
        warewolf = findViewById(R.id.warewolf);
        warewolf2 = findViewById(R.id.warewolf2);
        minion = findViewById(R.id.minion);
        freemason = findViewById(R.id.freemason);
        seer = findViewById(R.id.seer);
        robber = findViewById(R.id.robber);
        troublemaker = findViewById(R.id.troublemaker);
        drunk = findViewById(R.id.drunk);
        insomniac = findViewById(R.id.insomniac);


        if(Doppelganger.isChecked()){
            dp = true;
        }
        if(warewolf.isChecked()){
            w1 = true;
        }
        if(warewolf2.isChecked()){
            w2 = true;
        }
        if(minion.isChecked()){
            m = true;
        }
        if(freemason.isChecked()){
            free = true;
        }
        if(seer.isChecked()){
            se = true;
        }
        if(robber.isChecked()){
            rob = true;
        }
        if(troublemaker.isChecked()){
            tb = true;
        }
        if(drunk.isChecked()){
            dr = true;
        }
        if(insomniac.isChecked()){
            insom = true;
        }
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