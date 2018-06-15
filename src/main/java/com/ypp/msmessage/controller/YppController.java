package com.ypp.msmessage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ypp.msmessage.model.QueryMessageRequest;
import com.ypp.msmessage.service.YppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by baochunyu on 2017/8/12.
 */
@Slf4j
@Controller
public class YppController {

    @Autowired
    YppService yppService;

    @GetMapping("/v1/ypp")
    public String ypp(ModelMap model) {
        model.put("message","");
        return "ypp";
    }

    @RequestMapping("/v1/ypp/action")
    public String yppAction(@RequestParam(value = "startTime", required = false) String startTime,
                            @RequestParam(value = "endTime", required = false) String endTime,
                            @RequestParam(value = "fromUser", required = false) String fromUser,
                            @RequestParam(value = "toUser", required = false) String toUser,
                            ModelMap model) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

        QueryMessageRequest request = QueryMessageRequest.builder().beginTime(String.valueOf(dateFormat.parse(startTime).getTime()))
                .endTime(String.valueOf(dateFormat.parse(endTime).getTime()))
                .fromUser(fromUser)
                .toUser(toUser).build();

        String result = yppService.queryUserMessage(request);

        model.put("message",result);
        return "ypp";
    }
}
