package com.gourav.mcp.core;

import java.lang.reflect.Method;

public class McpToolDefinition {

    private String name;

    private String description;

    private Object bean;

    private Method method;

    public McpToolDefinition(
            String name,
            String description,
            Object bean,
            Method method
    ) {

        this.name = name;
        this.description = description;
        this.bean = bean;
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Object getBean() {
        return bean;
    }

    public Method getMethod() {
        return method;
    }
}