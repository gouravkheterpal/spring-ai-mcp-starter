# Spring AI MCP Starter

A modular Spring Boot starter framework for building MCP (Model Context Protocol) style AI tools with Spring AI and OpenAI integration.

---

## Features

- Dynamic MCP tool registration
- Annotation-based tool discovery
- Reflection-based tool invocation
- Spring Boot auto-configuration
- REST API endpoints
- Spring AI integration
- OpenAI chat support
- Modular Maven architecture

---

## Project Architecture

```text
spring-ai-mcp-starter
│
├── spring-ai-mcp-core
│   ├── annotations
│   ├── tool registry
│   ├── request/response models
│
├── spring-ai-mcp-autoconfigure
│   ├── auto configuration
│   ├── tool scanner
│   ├── invocation service
│   ├── REST controller
│
├── spring-ai-mcp-spring-boot-starter
│   ├── starter dependencies
│
├── samples/sample-chatbot
│   ├── sample application
│   ├── weather tool
│   ├── AI chat controller
```

---

## Tech Stack

- Java 21
- Spring Boot 3
- Spring AI
- OpenAI API
- Maven
- REST APIs

---

## Available APIs

### Get Registered Tools

```http
GET /mcp/tools
```

---

### Invoke MCP Tool

```http
POST /mcp/invoke
```

Request:

```json
{
  "toolName": "weather",
  "arguments": {
    "city": "Delhi"
  }
}
```

---

### AI Chat Endpoint

```http
POST /chat
```

Request:

```json
{
  "message": "Explain Java Streams simply"
}
```

---

## Example MCP Tool

```java
@McpTool(
    name = "weather",
    description = "Get weather details"
)
public String getWeather(String city) {
    return "Weather in " + city;
}
```

---

## How It Works

1. Spring scans all `@McpTool` annotations
2. Tools are registered into `McpToolRegistry`
3. APIs dynamically invoke tools using reflection
4. Spring AI integrates OpenAI chat capabilities
5. MCP tools become discoverable and executable at runtime

---

## Run Project

```bash
mvn clean install
```

Run sample application:

```bash
SampleChatbotApplication
```

---

## Future Roadmap

- AI tool calling
- Multi-tool orchestration
- Streaming responses
- Conversation memory
- Vector database integration
- Agent workflows
- Tool permissions/security

---

## License

MIT