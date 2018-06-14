package com.ypp.msmessage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangzhiqin
 * @create 2017-12-11 14:03
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueryMessageRequest {
    private String fromUser;
    private String toUser;
    private String beginTime;
    private String endTime;
}