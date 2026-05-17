package com.gourav.mcp.autoconfigure;

import com.gourav.mcp.core.McpTool;
import com.gourav.mcp.core.McpToolRegistry;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

@Component
public class McpToolScanner implements ApplicationContextAware {

    private final McpToolRegistry registry;

    public McpToolScanner(McpToolRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {

        String[] beanNames =
                applicationContext.getBeanDefinitionNames();

        for (String beanName : beanNames) {

            Object bean = applicationContext.getBean(beanName);

            Method[] methods =
                    bean.getClass().getDeclaredMethods();

            for (Method method : methods) {

                if (method.isAnnotationPresent(McpTool.class)) {

                    McpTool annotation =
                            method.getAnnotation(McpTool.class);

                    registry.register(
                            annotation.name(),
                            annotation.description(),
                            bean,
                            method
                    );

                    System.out.println(
                            "Registered MCP Tool: "
                                    + annotation.name()
                    );
                }
            }
        }
    }
}