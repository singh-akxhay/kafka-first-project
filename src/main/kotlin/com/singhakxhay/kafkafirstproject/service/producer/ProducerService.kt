package com.singhakxhay.kafkafirstproject.service.producer

import com.singhakxhay.kafkafirstproject.model.Message

interface ProducerService {
    fun sendMessage(message: Message): Unit
}
