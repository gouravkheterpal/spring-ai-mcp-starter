package com.gourav.mcp.autoconfigure.persistence.repository;

import com.gourav.mcp.autoconfigure.persistence.entity.ToolExecutionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToolExecutionHistoryRepository
        extends JpaRepository<ToolExecutionHistory, Long> {

    List<ToolExecutionHistory>
    findTop50ByOrderByCreatedAtDesc();
}
