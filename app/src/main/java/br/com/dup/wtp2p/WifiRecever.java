package br.com.dup.wtp2p;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;

/**
 * Created by admin on 03/02/16.
 */
public class WifiRecever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
            int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
            if (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
                //disponibilizando a informacao caso o cell aceite o p2p
                intent.putExtra("WIFI_P2P_IS_ENABLE", true);
            } else {
                intent.putExtra("WIFI_P2P_IS_ENABLE", false);
            }
        }
    }
}
