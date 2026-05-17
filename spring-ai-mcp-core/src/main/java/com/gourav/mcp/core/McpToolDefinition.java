package com.gourav.mcp.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

@Data
@AllArgsConstructor
public class McpToolDefinition {

    private String name;

    private String description;

    private Object bean;

    private Method method;
}