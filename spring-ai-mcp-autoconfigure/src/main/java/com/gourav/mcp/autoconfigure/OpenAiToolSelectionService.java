package com.gourav.mcp.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gourav.mcp.core.AiToolCall;
import com.gourav.mcp.core.McpToolDefinition;
import com.gourav.mcp.core.McpToolRegistry;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

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
            
            Your task is to choose the BEST tool for the user request.
            
            Available tools:
            
            %s
            
            Rules:
            
            1. Use "calculator" ONLY for mathematical calculations.
            2. Use "weather" ONLY for weather-related questions.
            3. Return ONLY valid JSON.
            4. Do not explain anything.
            5. Do not return markdown.
            6. Always include arguments.
            
            Examples:
            
            User:
            Calculate 45 * 12
            
            Response:
            {
              "toolName": "calculator",
              "arguments": {
                "expression": "45 * 12"
              }
            }
            
            User:
            What is weather in Delhi?
            
            Response:
            {
              "toolName": "weather",
              "arguments": {
                "city": "Delhi"
              }
            }
            
            Now process this user request:
            
            %s
            """.formatted(
                            toolDescriptions.toString(),
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

            int start =
                    response.indexOf("{");

            int end =
                    response.lastIndexOf("}");

            if (start == -1 || end == -1) {

                throw new RuntimeException(
                        "AI did not return valid JSON: "
                                + response
                );
            }

            String jsonResponse =
                    response.substring(
                            start,
                            end + 1
                    );

            return mapper.readValue(
                    jsonResponse,
                    AiToolCall.class
            );

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to parse AI response: "
                            + response,
                    e
            );
        }
    }
}