package com.singhakxhay.kafkafirstproject.controller

import com.singhakxhay.kafkafirstproject.model.Message
import com.singhakxhay.kafkafirstproject.repository.MessageRepository
import com.singhakxhay.kafkafirstproject.service.producer.ProducerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class MainController {
  @Autowired
  private lateinit var messageRepository: MessageRepository

  @Autowired
  private lateinit var producerService: ProducerService

  @GetMapping("/")
  fun getIndex(): ModelAndView {
    val modelAndView = ModelAndView("index")
    modelAndView.addObject("messages", messageRepository.getMessages())
    modelAndView.addObject("message", Message())
    return modelAndView
  }

  @PostMapping("/publishMessage")
  fun publishMessage(@ModelAttribute message: Message): String {
    producerService.sendMessage(message)
    return "redirect:/"
  }
}