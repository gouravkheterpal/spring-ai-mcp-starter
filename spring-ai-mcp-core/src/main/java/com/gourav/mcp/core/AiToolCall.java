package com.gourav.mcp.core;

import java.util.Map;

public class AiToolCall {

    private String tool;

    private Map<String, Object> arguments;

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public Map<String, Object> getArguments() {
        return arguments;
    }

    public void setArguments(
            Map<String, Object> arguments
    ) {
        this.arguments = arguments;
    }
}