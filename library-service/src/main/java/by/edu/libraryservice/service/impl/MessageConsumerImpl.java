package by.edu.libraryservice.service.impl;

import by.edu.libraryservice.service.BookOrderService;
import by.edu.libraryservice.service.MessageConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static by.edu.commonrabbitmq.RabbitQueue.BORROW_QUEUE;
import static by.edu.commonrabbitmq.RabbitQueue.RETURN_QUEUE;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageConsumerImpl implements MessageConsumer {

    private final BookOrderService bookOrderService;

    @Override
    @RabbitListener(queues = BORROW_QUEUE)
    public void consumeBorrowMessage(String message) {
        log.info("Id {} was consumed in borrow queue", message);
        bookOrderService.createOrder(message);
    }

    @Override
    @RabbitListener(queues = RETURN_QUEUE)
    public void consumeReturnMessage(String message) {
        System.out.println(message);
        log.info("Id {} was consumed in return queue", message);
        bookOrderService.deleteOrder(message);
    }
}
