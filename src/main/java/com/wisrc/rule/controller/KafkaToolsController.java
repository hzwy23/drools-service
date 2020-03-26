package com.wisrc.rule.controller;

import com.google.gson.Gson;
import com.wisrc.rule.vo.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class KafkaToolsController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping(value = "/rule/kafka/tool")
    public CommonResponse<String> write(@RequestParam String topic, @RequestBody Map<String,String> message){

        String data = new Gson().toJson(message);
        kafkaTemplate.send(topic, data);

        CommonResponse<String> status = new CommonResponse<>();
        status.setCode("200");
        status.setMsg("Bingo");
        status.setData(data);

        return status;
    }
}
