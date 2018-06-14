package com.ypp.msmessage.service;

import com.alibaba.fastjson.JSONObject;
import com.ypp.msmessage.model.QueryMessageRequest;
import com.ypp.msmessage.util.CheckSumBuilder;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by baochunyu on 2018/6/14.
 */
@Service
@Slf4j
public class YppService {

    @Value("${netease.key}")
    private String key;
    @Value("${netease.secret}")
    private String secret;
    @Value("${netease.nonce}")
    private String nonce;

    @Autowired
    OkHttpClient okHttpClient;

    public static final String YUNXIN_QUERY_USER_MESSAGE = "https://api.netease.im/nimserver/history/querySessionMsg.action";// 单聊云端历史消息查询


    public String queryUserMessage(QueryMessageRequest request) {
        log.info("yunxin queryUserMessage start:{}", JSONObject.toJSONString(request));
        RequestBody body = new FormBody.Builder()
                .add("from", request.getFromUser())
                .add("to", request.getToUser())
                .add("begintime", request.getBeginTime())
                .add("endtime", request.getEndTime())
                .add("limit", "100")
                .build();
        String result = sendYunxin(YUNXIN_QUERY_USER_MESSAGE, body);
        log.info("yunxin queryUserMessage end");
        return result;
    }

    public String sendYunxin(String url, RequestBody body) {

        String time = String.valueOf(System.currentTimeMillis() / 1000);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("AppKey", key)
                .addHeader("Nonce", nonce)
                .addHeader("CurTime", time)
                .addHeader("CheckSum", CheckSumBuilder.getCheckSum(secret, nonce, time))
                .post(body)
                .build();

        String result = "";
        try {
            Response response = okHttpClient.newCall(request).execute();
            result = response.body().string();
            log.info(result);
        } catch (IOException e) {
            log.error("netease io exception");
            e.printStackTrace();
        }

        return result;
    }

}
