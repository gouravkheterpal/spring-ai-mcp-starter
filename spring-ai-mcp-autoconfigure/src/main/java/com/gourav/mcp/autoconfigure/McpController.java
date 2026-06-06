package com.gourav.mcp.autoconfigure;

import com.gourav.mcp.autoconfigure.persistence.entity.ToolExecutionHistory;
import com.gourav.mcp.autoconfigure.persistence.repository.ToolExecutionHistoryRepository;
import com.gourav.mcp.core.McpToolInfo;
import com.gourav.mcp.core.McpToolRegistry;
import com.gourav.mcp.core.McpToolRequest;
import com.gourav.mcp.core.McpToolResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mcp")
public class McpController {

    private final McpInvocationService service;
    private final McpToolRegistry registry;
    private final ToolExecutionHistoryRepository repository;

    public McpController(
            McpInvocationService service,
            McpToolRegistry registry,
            ToolExecutionHistoryRepository repository
    ) {

        this.service = service;
        this.registry = registry;
        this.repository = repository;
    }

    @GetMapping("/tools")
    public List<McpToolInfo> getTools() {

        return registry.getTools()
                .values()
                .stream()
                .map(tool ->
                        new McpToolInfo(
                                tool.getName(),
                                tool.getDescription()
                        )
                )
                .collect(Collectors.toList());
    }

    @PostMapping("/invoke")
    public McpToolResponse invoke(
            @RequestBody McpToolRequest request
    ) {

        Object result =
                service.invoke(
                        request.getToolName(),
                        request.getArguments()
                );

        return new McpToolResponse(result);
    }

    @GetMapping("/audit")
    public List<ToolExecutionHistory> getAuditHistory() {

        return repository
                .findTop50ByOrderByCreatedAtDesc();
    }
}