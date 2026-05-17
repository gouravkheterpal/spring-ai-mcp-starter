package com.gourav.mcp.autoconfigure;

import org.springframework.stereotype.Service;
import com.gourav.mcp.core.AiToolCall;

@Service
public class AiToolExecutionService {

    private final McpInvocationService invocationService;
    private final OpenAiToolSelectionService toolSelector;

    public AiToolExecutionService(
            McpInvocationService invocationService,
            OpenAiToolSelectionService toolSelector
    ) {

        this.invocationService = invocationService;
        this.toolSelector = toolSelector;
    }

    public String processPrompt(
            String prompt
    ) {

        AiToolCall toolCall =
                toolSelector.selectTool(prompt);

        Object result =
                invocationService.invoke(
                        toolCall.getTool(),
                        toolCall.getArguments()
                );

        return String.valueOf(result);
    }

    private String extractCity(String prompt) {

        String[] words =
                prompt.split(" ");

        return words[words.length - 1];
    }
}