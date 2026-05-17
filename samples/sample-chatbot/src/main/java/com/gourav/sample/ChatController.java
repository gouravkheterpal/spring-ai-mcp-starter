package com.gourav.sample;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(
            ChatClient.Builder builder
    ) {

        this.chatClient = builder.build();
    }

    @PostMapping
    public String chat(
            @RequestBody ChatRequest request
    ) {

        return chatClient.prompt()
                .user(request.getMessage())
                .call()
                .content();
    }
}