package by.edu.bookservice.service;

public interface MessageProducer {
    void produce(String rabbitQueue, String message);
}
