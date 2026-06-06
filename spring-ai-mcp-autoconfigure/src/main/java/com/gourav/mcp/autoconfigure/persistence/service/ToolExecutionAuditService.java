package com.gourav.mcp.autoconfigure.persistence.service;

import com.gourav.mcp.autoconfigure.persistence.entity.ToolExecutionHistory;
import com.gourav.mcp.autoconfigure.persistence.repository.ToolExecutionHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ToolExecutionAuditService {

    private final ToolExecutionHistoryRepository repository;

    public ToolExecutionAuditService(
            ToolExecutionHistoryRepository repository
    ) {
        this.repository = repository;
    }

    public void save(
            String toolName,
            String arguments,
            String result,
            long executionTimeMs,
            String status,
            String errorMessage
    ) {

        ToolExecutionHistory history =
                new ToolExecutionHistory();

        history.setToolName(toolName);
        history.setArguments(arguments);
        history.setResult(result);
        history.setExecutionTimeMs(executionTimeMs);
        history.setCreatedAt(LocalDateTime.now());
        history.setStatus(status);
        history.setErrorMessage(errorMessage);

        repository.save(history);
    }
}