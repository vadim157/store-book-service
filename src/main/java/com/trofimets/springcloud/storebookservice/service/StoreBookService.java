package com.trofimets.springcloud.storebookservice.service;

import com.trofimets.springcloud.storebookservice.model.Book;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@EnableBinding(Sink.class)
@MessageEndpoint
public class StoreBookService {

    private final Logger logger = Logger.getLogger(StoreBookService.class.getName());

    @StreamListener(target = Sink.INPUT)
    public void handleMessage(Book book) throws Exception {
        logger.log(Level.INFO, "Book " + book);

    }
}
