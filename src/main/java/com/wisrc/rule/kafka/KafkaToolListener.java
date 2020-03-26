package com.wisrc.rule.kafka;

import com.google.gson.Gson;
import com.wisrc.rule.service.DroolsServices;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Configuration
@Slf4j
public class KafkaToolListener {

    @Autowired
    private DroolsServices droolsServices;

    @KafkaListener(topics = {"demo"})
    public void listen(ConsumerRecord<String,String> record){

        Optional<?> msg = Optional.ofNullable(record.value());
        if(msg.isPresent()) {

            Object message = msg.get();

            log.info("{}", message);

            HashMap<String, String> data = new Gson().fromJson(message.toString(),  HashMap.class);

            // 将从 Kafka Topic 内获取到的消息送入规则引擎进行匹配
            droolsServices.process(data);
        }
    }
}
