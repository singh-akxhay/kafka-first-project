package com.singhakxhay.kafkafirstproject.service.consumer

import com.singhakxhay.kafkafirstproject.model.Message

interface ConsumerService {
  fun consume(message: Message)
}