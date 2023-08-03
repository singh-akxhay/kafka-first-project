package com.singhakxhay.kafkafirstproject.service.consumer

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class ConsumerServiceImpl:ConsumerService {

    @KafkaListener(topics = ["users"], groupId = "group_id")
    override fun consume(message: String) {
        println("#### -> Consumed message -> $message")
    }
}