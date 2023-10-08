package by.edu.bookservice.service.impl;

import by.edu.bookservice.service.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageProducerImpl implements MessageProducer {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void produce(String rabbitQueue, String message) {
        rabbitTemplate.convertAndSend(rabbitQueue, message);
    }
}
