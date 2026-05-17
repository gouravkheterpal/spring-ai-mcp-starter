package com.gourav.mcp.autoconfigure;

import com.gourav.mcp.core.McpToolDefinition;
import com.gourav.mcp.core.McpToolRegistry;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Map;

@Service
public class McpInvocationService {

    private final McpToolRegistry registry;

    public McpInvocationService(
            McpToolRegistry registry
    ) {

        this.registry = registry;
    }

    public Object invoke(
            String toolName,
            Map<String, Object> arguments
    ) {

        try {

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

            return method.invoke(bean, args);

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}