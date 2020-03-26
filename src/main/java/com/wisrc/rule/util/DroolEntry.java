package com.wisrc.rule.util;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DroolEntry {

    public static void process(Map<String,Object> map, String bizCd){
        log.info("触发业务规则，数据是：{}, 触发规则是：{}", map, bizCd);
        // TODO 业务规则匹配成功，

        // TODO 根据 ruleId，针对不同的 ruleId，添加具体的业务处理逻辑
    }

}
