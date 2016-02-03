package br.com.dup.wtp2p;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.AudioTrack;

/**
 * Created by admin on 03/02/16.
 */
public interface WalktalkAudioConstants {
    static final int RATE_HZ = 8000;

    /** Buffer minimo para ser usado na gravação */
    final static int MIN_BUFFER_AUDIO_RECORD = AudioRecord.getMinBufferSize(RATE_HZ, AudioFormat.CHANNEL_IN_STEREO, AudioFormat.ENCODING_PCM_16BIT);
    final static int MIN_BUFFER_AUDIO_TRACK = AudioTrack.getMinBufferSize(RATE_HZ, AudioFormat.CHANNEL_IN_STEREO, AudioFormat.ENCODING_PCM_16BIT);

    /** tipos de driver, se é gravacao ou execuxao */
    final static int RESOURCE_TRACK = 0;
    final static int RESOURCE_RECORDING = 1;

    /** log */
    static final String APP_WTP2P = "wtp2p";
}
