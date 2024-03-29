package com.singhakxhay.kafkafirstproject.service.producer

import com.singhakxhay.kafkafirstproject.model.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

private const val TOPIC = "messages"

@Service
class ProducerServiceImpl : ProducerService {
    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, Message>

    override fun sendMessage(message: Message) {
        kafkaTemplate.send(TOPIC, message)
    }
}