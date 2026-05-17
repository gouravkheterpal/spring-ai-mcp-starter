package com.gourav.mcp.core;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface McpTool {

    String name();

    String description() default "";
}
