package com.singhakxhay.kafkafirstproject.model

import java.time.LocalDateTime

data class Message(val data: String, val publishedAt: String = LocalDateTime.now().toString()) {
  constructor() : this("")
}