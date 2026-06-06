package com.gourav.mcp.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gourav.mcp.autoconfigure.persistence.service.ToolExecutionAuditService;
import com.gourav.mcp.core.McpToolDefinition;
import com.gourav.mcp.core.McpToolRegistry;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Map;

@Service
public class McpInvocationService {

    private final McpToolRegistry registry;
    private final ToolExecutionAuditService auditService;
    private final ObjectMapper objectMapper;
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";

    public McpInvocationService(
            McpToolRegistry registry,
            ToolExecutionAuditService auditService,
            ObjectMapper objectMapper
    ) {
        this.registry = registry;
        this.auditService = auditService;
        this.objectMapper = objectMapper;
    }

    public Object invoke(
            String toolName,
            Map<String, Object> arguments
    ) {

        String argumentsJson = "{}";

        try {

            argumentsJson =
                    objectMapper.writeValueAsString(arguments);

            McpToolDefinition definition =
                    registry.getTool(toolName);

            if (definition == null) {

                throw new RuntimeException(
                        "Tool not found: " + toolName
                );
            }

            Method method =
                    definition.getMethod();

            Object bean =
                    definition.getBean();

            Object[] args =
                    arguments.values().toArray();

            long start =
                    System.currentTimeMillis();

            Object result =
                    method.invoke(bean, args);

            long end =
                    System.currentTimeMillis();

            auditService.save(
                    toolName,
                    argumentsJson,
                    String.valueOf(result),
                    end - start,
                    SUCCESS,
                    null
            );

            return result;

        } catch (Exception e) {

            auditService.save(
                    toolName,
                    argumentsJson,
                    null,
                    0,
                    FAILED,
                    e.getMessage() != null ? e.getMessage() : e.getClass().getSimpleName()
            );

            throw new RuntimeException(e);
        }
    }
}