package com.gourav.sample;

import com.gourav.mcp.core.McpToolRegistry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class McpToolRegistrationTest {

    @Autowired
    private McpToolRegistry registry;

    @Test
    void shouldRegisterWeatherTool() {

        assertNotNull(
                registry.getTool("weather")
        );
    }
}