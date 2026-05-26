# Spring AI MCP Starter

A modular Spring Boot framework for building AI-powered MCP (Model Context Protocol) style tools using Spring AI and Ollama.

This project demonstrates how to build an extensible AI orchestration framework capable of:
- AI-driven tool selection
- runtime tool discovery
- reflection-based invocation
- local LLM integration
- dynamic MCP-style execution pipelines

---

# Overview

This project demonstrates how modern AI agent systems work internally using:
- Spring Boot
- Spring AI
- Ollama
- Reflection-based execution
- Dynamic tool orchestration

The framework supports:
- Dynamic MCP tool registration
- Annotation-based tool discovery
- Reflection-based tool invocation
- AI-driven tool selection
- Local LLM execution using Ollama
- Structured JSON tool orchestration
- REST API exposure
- Runtime AI orchestration

---

# Features

## Core Framework Features

* Custom `@McpTool` annotation
* Runtime tool scanning
* Dynamic tool registry
* Reflection-based invocation engine
* Spring Boot auto-configuration
* Multi-module Maven architecture
* Extensible tool framework

---

## AI Features

* AI-powered tool selection
* Local LLM integration using Ollama
* Structured JSON tool orchestration
* AI-driven runtime execution
* Dynamic tool discovery
* Prompt-based tool routing
* Multi-tool orchestration support
* Local offline AI execution

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
│   ├── calculator tool
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
Spring AI + Ollama
    ↓
AI Tool Selection
    ↓
Structured JSON Response
    ↓
MCP Tool Registry
    ↓
Reflection-based Invocation
    ↓
Tool Execution
    ↓
Response Returned
```

---

# Tech Stack

| Technology        | Usage                         |
| ----------------- | ----------------------------- |
| Java 21           | Core language                 |
| Spring Boot 3.5   | Application framework         |
| Spring AI         | AI abstraction layer          |
| Ollama            | Local LLM runtime             |
| Maven             | Build system                  |
| REST APIs         | Communication                 |
| Reflection API    | Dynamic invocation            |
| Jackson           | JSON serialization            |

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
* Structured JSON parsing

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
* Calculator tool
* AI chat APIs
* MCP endpoint testing
* AI orchestration examples
* Ollama integration

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
  },
  {
    "name": "calculator",
    "description": "Perform mathematical calculations"
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

# AI Chat Endpoint

```http
POST /ai/chat
```

---

## Weather Example

### Request

```json
{
  "message": "What is weather in Delhi?"
}
```

### AI Flow

1. AI analyzes prompt
2. AI selects weather tool
3. AI generates arguments
4. Framework dynamically invokes tool
5. Response returned automatically

### Example AI Tool Selection

```json
{
  "toolName": "weather",
  "arguments": {
    "city": "Delhi"
  }
}
```

---

## Calculator Example

### Request

```json
{
  "message": "Calculate 45 * 12"
}
```

### AI Flow

1. AI analyzes prompt
2. AI selects calculator tool
3. AI generates arguments
4. Framework dynamically invokes tool
5. Result returned automatically

### Example Tool Selection

```json
{
  "toolName": "calculator",
  "arguments": {
    "expression": "45 * 12"
  }
}
```

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
5. AI dynamically discovers available tools
6. Reflection engine executes tools automatically

---

# AI Tool Selection Flow

```text
User Prompt
    ↓
AI receives available tool metadata
    ↓
AI selects best matching tool
    ↓
AI generates structured arguments
    ↓
Framework validates JSON response
    ↓
Reflection-based invocation executes tool
    ↓
Tool result returned
```

---

# Ollama Setup

## Install Ollama

https://ollama.com

---

## Pull Lightweight Model

```bash
ollama run gemma:2b
```

---

## Verify Installed Models

```bash
ollama list
```

---

# Configuration

Update:

```text
samples/sample-chatbot/src/main/resources/application.yml
```

```yaml
spring:
  ai:
    ollama:
      base-url: http://localhost:11434
      chat:
        model: gemma:2b
```

---

# Clone Repository

```bash
git clone https://github.com/gouravkheterpal/spring-ai-mcp-starter.git
```

---

# Build Project

```bash
mvn clean install
```

---

# Run Sample Application

```bash
mvn spring-boot:run
```

---

# Testing

## Run All Tests

```bash
mvn test
```

---

## Current Test Coverage

| Test                        | Purpose                           |
| --------------------------- | --------------------------------- |
| Tool Registration Test      | Verify annotation scanning        |
| Invocation Test             | Verify reflection execution       |
| Controller Test             | Verify REST APIs                  |
| AI Tool Selection Test      | Verify AI tool routing            |

---

# Current Capabilities

| Capability                     | Status |
| ------------------------------ | ------ |
| Dynamic tool discovery         | ✅ |
| Runtime tool registration      | ✅ |
| Reflection invocation          | ✅ |
| AI-driven tool selection       | ✅ |
| Structured AI responses        | ✅ |
| Multi-tool orchestration       | ✅ |
| Ollama local LLM integration   | ✅ |
| REST APIs                      | ✅ |
| Spring Boot starter            | ✅ |
| Modular architecture           | ✅ |

---

# Future Roadmap

## High Priority

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

### Tool Metadata APIs

Add:
* parameter schemas
* argument validation
* categories
* examples
* required field metadata

---

## Medium Priority

### Multiple Tools

Add more tools:
* Currency converter
* Stock price tool
* GitHub search tool
* Travel recommendation tool
* File summarization tool

---

### Structured Function Calling

Move from plain text AI responses to fully structured tool calls.

Example:

```json
{
  "toolName": "weather",
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
2. Recommend activities
3. Suggest travel plan

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

Support semantic retrieval and RAG applications.

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
* MCP architecture basics
* AI agent orchestration
* Structured AI outputs
* Dynamic execution pipelines
* Local LLM integration
* Modular backend engineering

---

# Key Engineering Concepts Demonstrated

* AI Tool Orchestration
* MCP-style Framework Design
* Annotation-driven Architecture
* Dynamic Tool Discovery
* Reflection-based Execution
* AI Prompt Engineering
* Structured JSON AI Outputs
* Local LLM Integration
* Spring Boot Starter Development
* Runtime Metadata Registration
* Extensible Modular Design

---

# Use Cases

* AI agent frameworks
* MCP experimentation
* Tool orchestration systems
* AI-enabled Spring Boot applications
* Research projects
* Backend architecture learning
* AI platform engineering experiments

---

# Open Source Contribution Highlights

This project demonstrates:
- framework design
- Spring Boot starter development
- AI infrastructure engineering
- modular architecture
- extensible AI orchestration systems

---

# Author

## Gourav Kheterpal

Java Full Stack Developer focused on:
- Spring Boot
- Spring AI
- AI Agents
- MCP Servers
- React
- Distributed Systems

LinkedIn:
https://www.linkedin.com/in/gourav-kheterpal-758a65201/

---

# License

MIT License