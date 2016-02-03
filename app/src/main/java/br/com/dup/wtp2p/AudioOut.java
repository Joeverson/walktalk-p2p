package br.com.dup.wtp2p;

import android.media.AudioTrack;
import android.util.Log;

class AudioOut{
    //driver de audio
    private static AudioTrack player;

    static{
        //preparando para poder ouvir o micriphone
        player = (AudioTrack) WalktalkBuild.biuld(WalktalkAudioConstants.RESOURCE_TRACK);

        if(player == null)
            Log.e(WalktalkAudioConstants.APP_WTP2P, "Track null");
    }

    public static void playing(int stData, short[] arrayShort){
        try{

            player.play();
            player.write(arrayShort, 0, stData);

        }catch(Throwable e){
            Log.e(WalktalkAudioConstants.APP_WTP2P, "erro na leitura do bagui");
        }
    }

    //finalizar a escuta
    public void stopPlay(){
        player.stop();
    }


}
