package com.singhakxhay.kafkafirstproject.service.consumer

import com.singhakxhay.kafkafirstproject.model.Message
import com.singhakxhay.kafkafirstproject.repository.MessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class ConsumerServiceImpl : ConsumerService {
  @Autowired
  private lateinit var messageRepository: MessageRepository

  @KafkaListener(topics = ["messages"], groupId = "group_id")
  override fun consume(message: Message) {
    this.messageRepository.addMessage(message)
  }
}