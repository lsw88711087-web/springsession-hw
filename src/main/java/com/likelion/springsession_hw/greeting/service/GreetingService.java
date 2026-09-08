package com.likelion.springsession_hw.greeting.service;

import org.springframework.stereotype.Service;
import com.likelion.springsession_hw.greeting.repository.MessageRepository;

import java.util.List;

@Service
public class GreetingService {

    private final MessageRepository messageRepository;

    public GreetingService(MessageRepository  messageRepository) {
        this.messageRepository = messageRepository;
    }


    public String greet(String name, int hour){
        String greeting;
        if (0 <= hour && hour <= 5){
            greeting = "아직 안주무셨어요?";
        }
        else if(hour < 12) {
            greeting = "좋은 아침이에요";
        }else if (hour <18){
            greeting = "좋은 오후에요";
        }else {
            greeting = "좋은 저녁이에요";
        }
        String result = greeting + ", " + name + "님!";
        messageRepository.save(result);

        return result;
    }

    public List<String> getAllMessages() {
        return messageRepository.findAll();
    }

}