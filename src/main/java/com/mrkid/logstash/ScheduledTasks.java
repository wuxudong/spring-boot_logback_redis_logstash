package com.mrkid.logstash;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger("logstash");

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Scheduled(fixedRate = 5000)
    public  void reportCurrentTime() throws JsonProcessingException {


        ReqEntry[] info = new ReqEntry[3];
        for (int i = 0; i < info.length; i++) {

            ReqEntry e = new ReqEntry();
            info[i] = e;
            e.bssid = UUID.randomUUID().toString();
            e.ssid = e.bssid;
            e.needExtraAuth = true;
            e.mCapabilities = "WPA2";
        }

        ResEntry[] res = new ResEntry[4];


        for (int i = 0; i < res.length; i++) {
            ResEntry e = new ResEntry();
            res[i] = e;
            e.bssid = info[0].bssid;
            e.ssid = info[0].ssid;
            e.sid = i;
            e.verify = (i % 2 == 0);
        }

        ReqResLog reqResLog = new ReqResLog();
        reqResLog.ip = "0.0.0.0";
        reqResLog.info = info;
        reqResLog.res = res;
        reqResLog.udid = UUID.randomUUID().toString();
        reqResLog.latitude = 0.0f;
        reqResLog.longitude = 0.0f;
        reqResLog.accuracy = 0.0f;
        reqResLog.uid = "";
        reqResLog.version = "1.0";


        log.info(objectMapper.writeValueAsString(reqResLog));

    }
}