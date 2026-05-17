package com.gourav.mcp.autoconfigure;

import com.gourav.mcp.core.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mcp")
public class McpController {

    private final McpInvocationService service;
    private final McpToolRegistry registry;

    public McpController(
            McpInvocationService service,
            McpToolRegistry registry
    ) {

        this.service = service;
        this.registry = registry;
    }

    @GetMapping("/tools")
    public List<McpToolInfo> getTools() {

        return registry.getTools()
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
}