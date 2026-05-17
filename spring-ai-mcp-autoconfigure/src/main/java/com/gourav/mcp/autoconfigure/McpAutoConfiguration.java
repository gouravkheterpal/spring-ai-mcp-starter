package com.gourav.mcp.autoconfigure;

import com.gourav.mcp.core.McpToolRegistry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.gourav.mcp.autoconfigure")
public class McpAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public McpToolRegistry mcpToolRegistry() {
        return new McpToolRegistry();
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}