package com.gourav.mcp.autoconfigure;

import com.gourav.mcp.core.McpToolDefinition;
import com.gourav.mcp.core.McpToolRegistry;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gourav.mcp.core.AiToolCall;

@Service
public class OpenAiToolSelectionService {

    private final ChatClient chatClient;
    private final McpToolRegistry registry;

    public OpenAiToolSelectionService(
            ChatClient.Builder builder,
            McpToolRegistry registry
    ) {

        this.chatClient = builder.build();
        this.registry = registry;
    }

    public AiToolCall selectTool(
            String userPrompt
    ) {

        StringBuilder toolDescriptions =
                new StringBuilder();

        for (McpToolDefinition tool :
                registry.getTools().values()) {

            toolDescriptions.append(
                            "Tool Name: ")
                    .append(tool.getName())
                    .append("\nDescription: ")
                    .append(tool.getDescription())
                    .append("\n\n");
        }

        String prompt = """
            You are an AI tool selector.

            Available tools:

            %s

            User request:
            %s

            Return response ONLY in JSON format.

            Example:
            {
              "tool": "weather",
              "arguments": {
                "city": "Delhi"
              }
            }
            """
                .formatted(
                        toolDescriptions,
                        userPrompt
                );

        String response =
                chatClient.prompt()
                        .user(prompt)
                        .call()
                        .content();

        try {

            ObjectMapper mapper =
                    new ObjectMapper();

            return mapper.readValue(
                    response,
                    AiToolCall.class
            );

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}