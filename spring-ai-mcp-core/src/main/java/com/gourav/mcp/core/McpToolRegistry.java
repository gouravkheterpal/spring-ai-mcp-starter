package com.gourav.mcp.core;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class McpToolRegistry {

    private final Map<String, McpToolDefinition> tools =
            new HashMap<>();

    public void register(
            String toolName,
            String description,
            Object bean,
            Method method
    ) {

        tools.put(
                toolName,
                new McpToolDefinition(
                        toolName,
                        description,
                        bean,
                        method
                )
        );
    }

    public McpToolDefinition getTool(
            String toolName
    ) {

        return tools.get(toolName);
    }

    public Collection<McpToolDefinition> getTools() {
        return tools.values();
    }
}