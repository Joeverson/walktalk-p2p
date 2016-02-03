package br.com.dup.wtp2p;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.util.Log;



class AudioIn {
    //flag de contole de gravação
    private static boolean isRecording = true;
    //inteiro que representa o audio em bytes
    private static AudioRecord audio;
    private static AudioTrack player;
    private static AudioManager am;
    private static Context context;

    static{
        player = (AudioTrack) WalktalkBuild.biuld(WalktalkAudioConstants.RESOURCE_TRACK);
        audio = (AudioRecord) WalktalkBuild.biuld(WalktalkAudioConstants.RESOURCE_RECORDING);
    }

    public static void listen(Context context){
        AudioIn.context = context;

        try{
            isRecording = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    AudioIn.reading();
                }
            }).start();
        }catch(IllegalArgumentException e){
            e.getStackTrace();
        }
    }

    //finalizar a escuta
    public static void stopListen(){
        am.setSpeakerphoneOn(false);
        isRecording = false;
        audio.stop();
        player.pause();
    }

    //Methodo de leitura do microphone
    private static void reading(){
        int sData = 0;
        short[] sizeShort = new short[WalktalkAudioConstants.MIN_BUFFER_AUDIO_TRACK];

        //configurando o microphone
        am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        am.setMode(AudioManager.MODE_NORMAL);

        //inicializando a escuta do microphone
        audio.startRecording();

        while (isRecording) {
            sData = audio.read(sizeShort, 0, WalktalkAudioConstants.MIN_BUFFER_AUDIO_RECORD);

            //wifi p2p deve transmitir daqui.
            //chamando o methodo a baixo no dispositivo cliente mandando as duas informaçoes
            AudioOut.playing(sData, sizeShort);
        }
    }

}
