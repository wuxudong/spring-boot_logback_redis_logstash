package com.mrkid.logstash;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * User: xudong
 * Date: 10/13/16
 * Time: 4:17 PM
 */
class ReqEntry {
    public String bssid;
    public String ssid;
    public boolean needExtraAuth;
    public String mCapabilities;
}


class ResEntry {
    public String bssid;
    public String ssid;
    public int sid;
    public boolean verify;
}


public class ReqResLog {
    public float latitude;
    public float longitude;
    public float accuracy;
    public String udid;

    public String uid;
    public String ip;
    public String version;


    public ReqEntry[] info = new ReqEntry[0];
    public ResEntry[] res = new ResEntry[0];

    public int getVerifyCount () {
        int count = 0;
        for (ResEntry e : res) {
            if (e.verify) {
                count++;
            }
        }

        return count;
    }
}
