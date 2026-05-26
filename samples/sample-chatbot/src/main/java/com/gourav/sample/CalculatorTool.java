package com.gourav.sample;

import com.gourav.mcp.core.McpTool;
import org.springframework.stereotype.Component;

@Component
public class CalculatorTool {

    @McpTool(
            name = "calculator",
            description = "Perform basic mathematical calculations"
    )
    public String calculate(
            String expression
    ) {

        try {

            expression =
                    expression.replaceAll(
                            "\\s+",
                            ""
                    );

            if (expression.contains("+")) {

                String[] parts =
                        expression.split("\\+");

                int result =
                        Integer.parseInt(parts[0])
                                + Integer.parseInt(parts[1]);

                return "Result: " + result;
            }

            if (expression.contains("-")) {

                String[] parts =
                        expression.split("-");

                int result =
                        Integer.parseInt(parts[0])
                                - Integer.parseInt(parts[1]);

                return "Result: " + result;
            }

            if (expression.contains("*")) {

                String[] parts =
                        expression.split("\\*");

                int result =
                        Integer.parseInt(parts[0])
                                * Integer.parseInt(parts[1]);

                return "Result: " + result;
            }

            if (expression.contains("/")) {

                String[] parts =
                        expression.split("/");

                int result =
                        Integer.parseInt(parts[0])
                                / Integer.parseInt(parts[1]);

                return "Result: " + result;
            }

            return "Unsupported operation";

        } catch (Exception e) {

            return "Invalid expression";
        }
    }
}