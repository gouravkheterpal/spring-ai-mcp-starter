package com.gourav.mcp.autoconfigure;

import com.gourav.mcp.core.McpToolRegistry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.gourav.mcp.autoconfigure")
@EnableJpaRepositories(
        basePackages = "com.gourav.mcp.autoconfigure.persistence.repository"
)
@EntityScan(
        basePackages = "com.gourav.mcp.autoconfigure.persistence.entity"
)
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