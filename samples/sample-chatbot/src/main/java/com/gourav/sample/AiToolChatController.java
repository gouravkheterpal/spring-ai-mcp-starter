package com.gourav.sample;

import com.gourav.mcp.autoconfigure.AiToolExecutionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class AiToolChatController {

    private final AiToolExecutionService service;

    public AiToolChatController(
            AiToolExecutionService service
    ) {
        this.service = service;
    }

    @PostMapping("/chat")
    public String chat(
            @RequestBody ChatRequest request
    ) {

        return service.processPrompt(
                request.getMessage()
        );
    }
}