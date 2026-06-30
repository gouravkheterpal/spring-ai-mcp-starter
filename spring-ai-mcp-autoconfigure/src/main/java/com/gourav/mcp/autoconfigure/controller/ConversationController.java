package com.gourav.mcp.autoconfigure.controller;

import com.gourav.mcp.autoconfigure.dto.CreateConversationRequest;
import com.gourav.mcp.autoconfigure.dto.MessageRequest;
import com.gourav.mcp.autoconfigure.persistence.entity.Conversation;
import com.gourav.mcp.autoconfigure.persistence.entity.Message;
import com.gourav.mcp.autoconfigure.persistence.service.ConversationMemoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conversation")
public class ConversationController {

    private final ConversationMemoryService memoryService;

    public ConversationController(
            ConversationMemoryService memoryService
    ) {
        this.memoryService = memoryService;
    }

    @PostMapping
    public Conversation createConversation(
            @RequestBody CreateConversationRequest request
    ) {

        return memoryService.createConversation(
                request.getTitle()
        );
    }

    @PostMapping("/{id}/user")
    public Message addUserMessage(
            @PathVariable Long id,
            @RequestBody MessageRequest request
    ) {

        return memoryService.addUserMessage(
                id,
                request.getContent()
        );
    }

    @PostMapping("/{id}/assistant")
    public Message addAssistantMessage(
            @PathVariable Long id,
            @RequestBody MessageRequest request
    ) {

        return memoryService.addAssistantMessage(
                id,
                request.getContent()
        );
    }

    @GetMapping("/{id}")
    public List<Message> getHistory(
            @PathVariable Long id
    ) {

        return memoryService.getConversationHistory(id);
    }
}