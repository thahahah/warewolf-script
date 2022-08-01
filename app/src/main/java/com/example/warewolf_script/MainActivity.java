package com.example.warewolf_script;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backKeyPressedTime = 0;
    private Button button;
    private RadioButton Doppelganger, warewolf, warewolf2, minion, freemason, seer, robber, troublemaker, drunk, insomniac;
    boolean dp, w1, w2, m, free, se, rob, tb, dr, inso = false;
    int min = 0;
    SoundPool soundPool;
    int soundID;

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
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Doppelganger.isChecked()){
                    dp = true;
                    min += 1;
                }
                if(warewolf.isChecked()){
                    w1 = true;
                    min += 1;
                }
                if(warewolf2.isChecked()){
                    w2 = true;
                    min += 1;
                }
                if(minion.isChecked()){
                    m = true;
                    min += 1;
                }
                if(freemason.isChecked()){
                    free = true;
                    min += 1;
                }
                if(seer.isChecked()){
                    se = true;
                    min += 1;
                }
                if(robber.isChecked()){
                    rob = true;
                    min += 1;
                }
                if(troublemaker.isChecked()){
                    tb = true;
                    min += 1;
                }
                if(drunk.isChecked()){
                    dr = true;
                    min += 1;
                }
                if(insomniac.isChecked()){
                    inso = true;
                    min += 1;
                }
                if(min < 3){
                    Toast.makeText(getApplicationContext(), "직업은 최소 3개 이상을 선택해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(min >= 3){
                    setContentView(R.layout.activity_main);
                    finish();
                }

            }
        });

    }

    public void MainScript(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundID = soundPool.load(this,R.raw.chime1,1);

        soundPool.play(soundID,1f,1f,0,0,1f);

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