package br.com.dup.wtp2p;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaRecorder;

/**
 * Created by admin on 03/02/16.
 */
public class WalktalkBuild implements WalktalkAudioConstants{

    private static AudioTrack audiotrack;
    private static AudioRecord audiorecord;

    public static Object biuld(int type){
        switch(type){
            case RESOURCE_RECORDING:
                return getInstanceRecord();
            case RESOURCE_TRACK:
                return getInstanceTrack();
        }

        return null;
    }

    private static AudioRecord getInstanceRecord(){
        if(audiorecord == null){
            audiorecord = new AudioRecord(MediaRecorder.AudioSource.MIC,
                    RATE_HZ,
                    AudioFormat.CHANNEL_IN_STEREO,
                    AudioFormat.ENCODING_PCM_16BIT,
                    MIN_BUFFER_AUDIO_RECORD);
        }

        return audiorecord;
    }

    private static AudioTrack getInstanceTrack(){
        if(audiotrack == null){
            audiotrack = new AudioTrack(AudioManager.STREAM_SYSTEM,
                    RATE_HZ,
                    AudioFormat.CHANNEL_IN_STEREO,
                    AudioFormat.ENCODING_PCM_16BIT,
                    MIN_BUFFER_AUDIO_TRACK,
                    AudioTrack.MODE_STREAM);
        }

        return audiotrack;
    }
}
