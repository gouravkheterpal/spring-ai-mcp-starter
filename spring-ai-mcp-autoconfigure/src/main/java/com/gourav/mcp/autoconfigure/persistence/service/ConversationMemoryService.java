package com.gourav.mcp.autoconfigure.persistence.service;

import com.gourav.mcp.autoconfigure.persistence.entity.Conversation;
import com.gourav.mcp.autoconfigure.persistence.entity.Message;
import com.gourav.mcp.autoconfigure.persistence.repository.ConversationRepository;
import com.gourav.mcp.autoconfigure.persistence.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConversationMemoryService {

    private final ConversationRepository conversationRepository;
    private final MessageRepository messageRepository;

    public ConversationMemoryService(
            ConversationRepository conversationRepository,
            MessageRepository messageRepository
    ) {
        this.conversationRepository = conversationRepository;
        this.messageRepository = messageRepository;
    }

    public Conversation createConversation(String title) {

        Conversation conversation =
                new Conversation();

        conversation.setTitle(title);
        conversation.setCreatedAt(LocalDateTime.now());

        return conversationRepository.save(conversation);
    }

    public Message addUserMessage(
            Long conversationId,
            String content
    ) {

        Message message =
                new Message();

        message.setConversationId(conversationId);
        message.setRole("USER");
        message.setContent(content);
        message.setCreatedAt(LocalDateTime.now());

        return messageRepository.save(message);
    }

    public Message addAssistantMessage(
            Long conversationId,
            String content
    ) {

        Message message =
                new Message();

        message.setConversationId(conversationId);
        message.setRole("ASSISTANT");
        message.setContent(content);
        message.setCreatedAt(LocalDateTime.now());

        return messageRepository.save(message);
    }

    public List<Message> getConversationHistory(
            Long conversationId
    ) {

        return messageRepository
                .findByConversationIdOrderByCreatedAtAsc(
                        conversationId
                );
    }
}