package com.gourav.sample;

import com.gourav.mcp.autoconfigure.McpInvocationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class McpInvocationServiceTest {

    @Autowired
    private McpInvocationService service;

    @Test
    void shouldInvokeWeatherTool() {

        Object result =
                service.invoke(
                        "weather",
                        Map.of("city", "Delhi")
                );

        assertNotNull(result);
    }
}