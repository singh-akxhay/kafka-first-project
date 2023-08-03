package com.singhakxhay.kafkafirstproject.controller

import com.singhakxhay.kafkafirstproject.model.Message
import com.singhakxhay.kafkafirstproject.service.producer.ProducerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/messages")
class MessageController {
    @Autowired
    private lateinit var producerService: ProducerService

    @PostMapping("/publish")
    fun publishMessage(@RequestBody message:Message){
        producerService.sendMessage(message)
    }
}