package com.bookmycar.bookmycar.serviceImpl;


import com.bookmycar.bookmycar.request.UserInfoRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;

    public MessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send() {
        rabbitTemplate.convertAndSend("document.queue", "Hello RabbitMQ");
        System.out.println("Message sent!");
    }

    public boolean sendUserData(UserInfoRequest userInfoRequest) {

        Boolean response = (Boolean) rabbitTemplate.convertSendAndReceive(
                "",
                "user.queue",
                userInfoRequest
        );
        return response != null && response;
    }


    @RabbitListener(queues = "dummy.queue")
    public void receive(String message) {
        System.out.println("Received message: " + message);
    }
}
