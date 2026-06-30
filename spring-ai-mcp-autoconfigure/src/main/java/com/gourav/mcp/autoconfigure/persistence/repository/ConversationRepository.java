package com.gourav.mcp.autoconfigure.persistence.repository;

import com.gourav.mcp.autoconfigure.persistence.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository
        extends JpaRepository<Conversation, Long> {
}