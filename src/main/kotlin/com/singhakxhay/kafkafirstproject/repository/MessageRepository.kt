package com.singhakxhay.kafkafirstproject.repository

import com.singhakxhay.kafkafirstproject.model.Message
import org.springframework.stereotype.Component

@Component
class MessageRepository {
  private val messages = mutableListOf<Message>()

  fun addMessage(message: Message) {
    this.messages.add(message)
  }

  fun getMessages() = this.messages
}