package com.gourav.mcp.core;

import lombok.Data;

import java.util.Map;

@Data
public class McpToolRequest {

    private String toolName;

    private Map<String, Object> arguments;
}