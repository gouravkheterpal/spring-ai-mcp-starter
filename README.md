# Spring AI MCP Starter

A modular Spring Boot framework for building AI-powered MCP (Model Context Protocol) style tools using Spring AI and OpenAI.

---

# Overview

This project demonstrates how to build a lightweight AI tool orchestration framework similar to modern AI agent systems.

The framework supports:

* Dynamic MCP tool registration
* Annotation-based tool discovery
* Reflection-based tool invocation
* AI-driven tool selection
* OpenAI integration using Spring AI
* Modular Spring Boot starter architecture
* REST API exposure
* Runtime tool orchestration

---

# Features

## Core Framework Features

* Custom `@McpTool` annotation
* Runtime tool scanning
* Dynamic tool registry
* Reflection-based invocation engine
* Spring Boot auto-configuration
* Multi-module Maven architecture

---

## AI Features

* OpenAI-powered tool selection
* Prompt-based tool orchestration
* AI-driven runtime execution
* Dynamic tool discovery
* Structured tool invocation flow

---

## API Features

* REST APIs for MCP tools
* AI chat endpoint
* JSON request/response support
* Dynamic invocation endpoint

---

# Project Architecture

```text
spring-ai-mcp-starter
│
├── spring-ai-mcp-core
│   ├── @McpTool annotation
│   ├── tool registry
│   ├── DTOs
│   ├── request/response models
│
├── spring-ai-mcp-autoconfigure
│   ├── tool scanner
│   ├── auto configuration
│   ├── invocation service
│   ├── AI tool selection service
│   ├── REST controller
│
├── spring-ai-mcp-spring-boot-starter
│   ├── starter dependencies
│
├── samples/sample-chatbot
│   ├── sample application
│   ├── weather tool
│   ├── AI chat controller
│   ├── chatbot APIs
```

---

# Runtime Flow

```text
User Prompt
    ↓
AI Chat Endpoint
    ↓
OpenAI Tool Selection
    ↓
MCP Tool Registry
    ↓
Dynamic Tool Invocation
    ↓
Tool Execution
    ↓
Response Returned
```

---

# Tech Stack

| Technology     | Usage                 |
| -------------- | --------------------- |
| Java 21        | Core language         |
| Spring Boot 3  | Application framework |
| Spring AI      | OpenAI integration    |
| OpenAI API     | AI orchestration      |
| Maven          | Build system          |
| REST APIs      | Communication         |
| Reflection API | Dynamic invocation    |

---

# Modules Explained

## spring-ai-mcp-core

Contains the foundational framework components.

### Responsibilities

* MCP annotations
* Tool metadata
* Registry management
* DTOs
* Request/response contracts

---

## spring-ai-mcp-autoconfigure

Handles Spring Boot auto configuration and runtime orchestration.

### Responsibilities

* Tool scanning
* Dynamic registration
* Reflection invocation
* AI tool selection
* REST APIs

---

## spring-ai-mcp-spring-boot-starter

Provides starter dependency support.

### Responsibilities

* Simplified integration
* Dependency aggregation
* Starter bootstrapping

---

## sample-chatbot

Sample application demonstrating framework usage.

### Responsibilities

* Weather tool
* AI chat APIs
* MCP endpoint testing
* OpenAI integration examples

---

# Available APIs

## Get Registered Tools

```http
GET /mcp/tools
```

### Example Response

```json
[
  {
    "name": "weather",
    "description": "Get weather details"
  }
]
```

---

## Invoke MCP Tool

```http
POST /mcp/invoke
```

### Request

```json
{
  "toolName": "weather",
  "arguments": {
    "city": "Delhi"
  }
}
```

### Response

```json
{
  "result": "Weather in Delhi"
}
```

---

## AI Chat Endpoint

```http
POST /ai/chat
```

### Request

```json
{
  "message": "What is weather in Hyderabad?"
}
```

### AI Flow

1. OpenAI analyzes prompt
2. AI selects matching MCP tool
3. Framework dynamically invokes tool
4. Response returned automatically

---

# Example MCP Tool

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

# How Dynamic Tool Registration Works

1. Spring scans beans at startup
2. Framework finds methods annotated with `@McpTool`
3. Tools are registered into `McpToolRegistry`
4. Metadata becomes available at runtime
5. AI can dynamically discover tools
6. Invocation engine executes tools using reflection

---

# AI Tool Selection Flow

```text
User Prompt
    ↓
OpenAI analyzes available tools
    ↓
AI selects best matching tool
    ↓
Framework invokes tool dynamically
    ↓
Tool result returned
```

---

# Setup Instructions

## Clone Repository

```bash
git clone https://github.com/gouravkheterpal/spring-ai-mcp-starter.git
```

---

## Build Project

```bash
mvn clean install
```

---

## Configure OpenAI API Key

Update:

```text
samples/sample-chatbot/src/main/resources/application.yml
```

```yaml
spring:
  ai:
    openai:
      api-key: YOUR_OPENAI_API_KEY
```

---

## Run Sample Application

Run:

```text
SampleChatbotApplication
```

---

# Testing

## Run All Tests

```bash
mvn test
```

---

## Current Test Coverage

| Test                   | Purpose                     |
| ---------------------- | --------------------------- |
| Tool Registration Test | Verify annotation scanning  |
| Invocation Test        | Verify reflection execution |
| Controller Test        | Verify REST APIs            |

---

# Current Capabilities

| Capability                | Status |
| ------------------------- | ------ |
| Dynamic tool discovery    | ✅      |
| Runtime tool registration | ✅      |
| Reflection invocation     | ✅      |
| OpenAI integration        | ✅      |
| AI-driven tool selection  | ✅      |
| REST APIs                 | ✅      |
| Spring Boot starter       | ✅      |
| Modular architecture      | ✅      |

---

# Future Roadmap

## High Priority

### README Improvements

Improve documentation and developer onboarding.

---

### Architecture Diagram

Add visual architecture flow diagrams.

---

### Better Test Coverage

Add:

* Unit tests
* Integration tests
* Mock-based AI tests
* API contract tests

---

## Medium Priority

### Multiple Tools

Add more tools:

* Calculator tool
* Currency converter
* Stock price tool
* GitHub search tool
* Travel recommendation tool

---

### Structured Function Calling

Move from plain text AI responses to structured JSON tool calls.

Example:

```json
{
  "tool": "weather",
  "arguments": {
    "city": "Delhi"
  }
}
```

---

### Enhanced Tool Metadata

Add:

* parameter schemas
* required fields
* return types
* categories
* examples

---

## Advanced Features

### Multi-Step Agents

AI executes multiple tools sequentially.

Example:

1. Get weather
2. Convert temperature
3. Recommend activities

---

### Tool Chaining

Output from one tool becomes input for another.

---

### Conversation Memory

Remember prior prompts and tool outputs.

---

### Autonomous Workflows

AI independently plans and executes workflows.

---

### Streaming Responses

Real-time AI streaming responses.

---

### Vector Database Integration

Support semantic retrieval and RAG.

---

### Docker Support

Containerized deployment.

---

### Maven Central Publishing

Publish framework as reusable public starter.

---

# Learning Outcomes

This project demonstrates:

* Spring Boot internals
* Custom starter creation
* Auto configuration
* Reflection API usage
* Runtime orchestration
* AI integration
* Agent architecture basics
* Dynamic execution pipelines
* Modular backend engineering

---

# Use Cases

* AI agent frameworks
* MCP experimentation
* Tool orchestration systems
* AI-enabled Spring Boot apps
* Research projects
* Backend architecture learning

---

# License

MIT License
