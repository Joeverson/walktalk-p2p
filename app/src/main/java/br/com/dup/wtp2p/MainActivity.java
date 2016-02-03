package br.com.dup.wtp2p;

import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setVolumeControlStream(AudioManager.MODE_IN_COMMUNICATION);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                AudioIn.listen(this);
                break;
            case MotionEvent.ACTION_UP:
                AudioIn.stopListen();
                break;
        }

        return true;
    }


    ////// method reposavel para saber se o app pode usar o p2p ou nao
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data.getBooleanExtra("WIFI_P2P_IS_ENABLE", false))
            Log.e(WalktalkAudioConstants.APP_WTP2P, "ele aceita o p2p");
        else
            Log.e(WalktalkAudioConstants.APP_WTP2P, "ele nao aceita o p2p");
    }
}
