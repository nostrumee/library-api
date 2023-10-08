package by.edu.libraryservice.service;

public interface MessageConsumer {

    void consumeBorrowMessage(String message);

    void consumeReturnMessage(String message);
}
