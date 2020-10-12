package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech tts;//음성출력 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts = new TextToSpeech(this, new android.speech.tts.TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status){
                if(status != android.speech.tts.TextToSpeech.ERROR){
                    tts.setLanguage(Locale.KOREAN);
                }
            }
        });


    }


    public void Click(View v){// 비콘 수신 기능 개발 전 다음 페이지로 넘어가기 위한 버튼 (Activity 이동)
        Intent intent = new Intent(MainActivity.this,select_destination.class);
        //intent.putExtra("category",);//category 넘겨주기

        //비콘 수신 기능 구현 시 사용
        String speak = "안녕하세요";
        tts.setPitch(1.5f);//tone
        tts.setSpeechRate(1.0f);//speed
        tts.speak(speak,TextToSpeech.QUEUE_FLUSH,null);//speech


        startActivity(intent);//select_destination 페이지로 이동
    }
}
