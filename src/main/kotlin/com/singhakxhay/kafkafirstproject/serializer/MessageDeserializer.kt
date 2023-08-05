package com.singhakxhay.kafkafirstproject.serializer

import com.fasterxml.jackson.databind.ObjectMapper
import com.singhakxhay.kafkafirstproject.model.Message
import org.apache.kafka.common.serialization.Deserializer
import java.nio.charset.StandardCharsets


class MessageDeserializer : Deserializer<Message> {
  private val objectMapper = ObjectMapper()

  override fun deserialize(topic: String, data: ByteArray): Message = try {
    // Convert the byte array to a JSON string
    val jsonString = String(data, StandardCharsets.UTF_8)

    // Deserialize the JSON string back to Message object
    objectMapper.readValue(jsonString, Message::class.java)
  } catch (e: Exception) {
    throw RuntimeException("Not able to de-serialize message object")
  }
}

