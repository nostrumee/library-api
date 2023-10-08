package by.edu.commonrabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static by.edu.commonrabbitmq.RabbitQueue.BORROW_QUEUE;
import static by.edu.commonrabbitmq.RabbitQueue.RETURN_QUEUE;

@Configuration
@RequiredArgsConstructor
public class RabbitConfiguration {

    private final ConnectionFactory connectionFactory;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jacksonConverter());
        return rabbitTemplate;
    }

    @Bean
    public MessageConverter jacksonConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue borrowQueue(){
        return new Queue(BORROW_QUEUE);
    }

    @Bean
    public Queue returnQueue(){
        return new Queue(RETURN_QUEUE);
    }
}
