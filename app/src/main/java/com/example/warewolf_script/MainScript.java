package com.example.warewolf_script;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainScript extends AppCompatActivity {
    private long backKeyPressedTime = 0;
    public Button btn_finish;
    private MediaPlayer mediaPlayer;
    int count = 5;
    int count1 = 3;
    CountDownTimer countDownTimer;
    int dp, w, m, m1, free, se, rob, tb, dr, inso, inso1 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_script);
        btn_finish = findViewById(R.id.btn_finish);
        Intent intent = getIntent();
        dp = intent.getIntExtra("dp", 0);
        w = intent.getIntExtra("w", 0);
        m = intent.getIntExtra("m", 0);
        m1 = intent.getIntExtra("m1", 0);
        free = intent.getIntExtra("free", 0);
        se = intent.getIntExtra("se", 0);
        rob = intent.getIntExtra("rob", 0);
        tb = intent.getIntExtra("tb", 0);
        dr = intent.getIntExtra("dr", 0);
        inso = intent.getIntExtra("inso", 0);
        inso1 = intent.getIntExtra("inso1", 0);


        //시작
        bell.start();

        //종료
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainScript.this, MainActivity.class);
                startActivity(intent);
                System.exit(0);
            }
        });

    }

    @Override
    public void onBackPressed() {
        // 뒤로가기 버튼 2번 누를 시 종료
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(getApplicationContext(), "" + dp, Toast.LENGTH_SHORT).show();
            return;
        }

        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            // 앱 완전 종료 코드
            ActivityCompat.finishAffinity(this);
            System.exit(0);
        }

    }

    //소리 호출 시 작동
    CountDownTimer bell = new CountDownTimer(1500, 1500) {
        @Override
        public void onTick(long l) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.chime1);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

        @Override
        public void onFinish() {
            mediaPlayer = null;
            voice11.start();
        }
    };

    //night
    CountDownTimer voice11 = new CountDownTimer(5000, 5000) {
        @Override
        public void onTick(long l) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.voice1);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

        @Override
        public void onFinish() {
            mediaPlayer = null;
            if (dp == 1) {
                voice_dp.start();
                dp = 0;
            } else if (w ==1) {
                voice_w1.start();
                w = 0;
            } else if (m == 1) {
                voice_m.start();
                m=0;
            } else if (m1 == 1){
                voice_dp_m.start();
                m1 = 0;
            } else if (free == 1) {
                voice_free.start();
                free = 0;
            } else if (se == 1) {
                voice_se.start();
                se = 0;
            } else if (rob == 1) {
                voice_rob.start();
                rob = 0;
            } else if (tb == 1) {
                voice_tb.start();
                tb = 0;
            } else if (dr == 1) {
                voice_dr.start();
                dr = 0;
            } else if (inso == 1) {
                voice_inso.start();
                inso = 0;
            } else if (inso1 == 1){
                voice_dp_inso.start();
                inso1 = 0;
            } else {
                voice_end.start();
            }
        }
    };
    //dp
    CountDownTimer voice_dp = new CountDownTimer(16000, 16000) {
        @Override
        public void onTick(long l) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.dp);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

        @Override
        public void onFinish() {
            mediaPlayer = null;
            clock1.start();
        }
    };
    //w
    CountDownTimer voice_w1 = new CountDownTimer(10000, 10000) {
        @Override
        public void onTick(long l) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.w);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

        @Override
        public void onFinish() {
            mediaPlayer = null;
            clock1.start();
        }
    };
    //하수인
    CountDownTimer voice_m = new CountDownTimer(12000, 12000) {
        @Override
        public void onTick(long l) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.m);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

        @Override
        public void onFinish() {
            mediaPlayer = null;
            clock2.start();
        }
    };
    //도플 하수인
    CountDownTimer voice_dp_m = new CountDownTimer(14000, 14000) {
        @Override
        public void onTick(long l) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.dp_m);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

        @Override
        public void onFinish() {
            mediaPlayer = null;
            clock2.start();
        }
    };
    //프리메이슨
    CountDownTimer voice_free = new CountDownTimer(6000, 6000) {
        @Override
        public void onTick(long l) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.free);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

        @Override
        public void onFinish() {
            mediaPlayer = null;
            clock2.start();
        }
    };
    //예언자
    CountDownTimer voice_se = new CountDownTimer(9000, 9000) {
        @Override
        public void onTick(long l) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.se);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

        @Override
        public void onFinish() {
            mediaPlayer = null;
            clock1.start();
        }
    };
    //강도
    CountDownTimer voice_rob = new CountDownTimer(8000, 8000) {
        @Override
        public void onTick(long l) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.rob);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

        @Override
        public void onFinish() {
            mediaPlayer = null;
            clock1.start();
        }
    };
    //말썽쟁이
    CountDownTimer voice_tb = new CountDownTimer(7000, 7000) {
        @Override
        public void onTick(long l) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tb);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

        @Override
        public void onFinish() {
            mediaPlayer = null;
            clock1.start();
        }
    };
    //주정뱅이
    CountDownTimer voice_dr = new CountDownTimer(8000, 8000) {
        @Override
        public void onTick(long l) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.dr);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

        @Override
        public void onFinish() {
            mediaPlayer = null;
            clock1.start();
        }
    };
    //불면증환자
    CountDownTimer voice_inso = new CountDownTimer(7000, 7000) {
        @Override
        public void onTick(long l) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.inso);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

        @Override
        public void onFinish() {
            mediaPlayer = null;
            clock1.start();
        }
    };
    //도플불면증
    CountDownTimer voice_dp_inso = new CountDownTimer(8000, 8000) {
        @Override
        public void onTick(long l) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.dp_inso);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

        @Override
        public void onFinish() {
            mediaPlayer = null;
            clock1.start();
        }
    };
    //시계 소리
    CountDownTimer clock1 = new CountDownTimer(6000, 1000) {
        @SuppressLint("SetTextI18n")
        @Override
        public void onTick(long l) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.clock1);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
            TextView textView = (TextView) findViewById(R.id.timer);
            textView.setText("" + count--);
        }

        @Override
        public void onFinish() {
            TextView textView = (TextView) findViewById(R.id.timer);
            textView.setText("");
            count = 5;
            mediaPlayer = null;
            if (dp == 1) {
                voice_dp.start();
                dp = 0;
            } else if (w ==1) {
                voice_w1.start();
                w = 0;
            } else if (m == 1) {
                voice_m.start();
                m=0;
            } else if (m1 == 1){
                voice_dp_m.start();
                m1 = 0;
            } else if (free == 1) {
                voice_free.start();
                free = 0;
            } else if (se == 1) {
                voice_se.start();
                se = 0;
            } else if (rob == 1) {
                voice_rob.start();
                rob = 0;
            } else if (tb == 1) {
                voice_tb.start();
                tb = 0;
            } else if (dr == 1) {
                voice_dr.start();
                dr = 0;
            } else if (inso == 1) {
                voice_inso.start();
                inso = 0;
            } else if (inso1 == 1){
                voice_dp_inso.start();
                inso1 = 0;
            } else {
                voice_end.start();
            }
        }

    };
    CountDownTimer clock2 = new CountDownTimer(4000, 1000) {
        @SuppressLint("SetTextI18n")
        @Override
        public void onTick(long l) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.clock1);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
            TextView textView = (TextView) findViewById(R.id.timer);
            textView.setText("" + count1--);
        }

        @Override
        public void onFinish() {
            TextView textView = (TextView) findViewById(R.id.timer);
            textView.setText("");
            mediaPlayer = null;
            count1 = 3;
            if (dp == 1) {
                voice_dp.start();
                dp = 0;
            } else if (w ==1) {
                voice_w1.start();
                w = 0;
            } else if (m == 1) {
                voice_m.start();
                m=0;
            } else if (m1 == 1){
                voice_dp_m.start();
                m1 = 0;
            } else if (free == 1) {
                voice_free.start();
                free = 0;
            } else if (se == 1) {
                voice_se.start();
                se = 0;
            } else if (rob == 1) {
                voice_rob.start();
                rob = 0;
            } else if (tb == 1) {
                voice_tb.start();
                tb = 0;
            } else if (dr == 1) {
                voice_dr.start();
                dr = 0;
            } else if (inso == 1) {
                voice_inso.start();
                inso = 0;
            } else if (inso1 == 1){
                voice_dp_inso.start();
                inso1 = 0;
            } else {
                voice_end.start();
            }
        }

    };
    //낮이 되었습니다
    CountDownTimer voice_end = new CountDownTimer(3000, 3000) {
        @Override
        public void onTick(long l) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.game_end);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });

        }

        @Override
        public void onFinish() {
            mediaPlayer = null;
            Intent intent = new Intent(MainScript.this, MainActivity.class);
            startActivity(intent);
            System.exit(0);
        }
    };

}