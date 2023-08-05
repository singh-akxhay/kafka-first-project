package com.singhakxhay.kafkafirstproject.serializer

import com.fasterxml.jackson.databind.ObjectMapper
import com.singhakxhay.kafkafirstproject.model.Message
import org.apache.kafka.common.serialization.Serializer
import java.nio.charset.StandardCharsets


class MessageSerializer : Serializer<Message> {
  private val objectMapper = ObjectMapper()
  override fun serialize(topic: String, data: Message): ByteArray {
    return try {
      // Convert the data object to a JSON string
      val jsonString = objectMapper.writeValueAsString(data)
      jsonString.toByteArray(StandardCharsets.UTF_8)
    } catch (e: Exception) {
      // Handle serialization errors here
      e.printStackTrace()
      byteArrayOf()
    }
  }
}

