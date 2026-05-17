# spring-ai-claude-api

API REST mínima com Java 21, Spring Boot 3.5+, Maven 3.9.15, Spring AI e Anthropic Claude.

## Requisitos

- Java 21
- Maven 3.9.15+
- Visual Studio Code (com extensões Java recomendadas)
- Chave da Anthropic

## Configurar variável de ambiente

### PowerShell (sessão atual)

```powershell
$env:ANTHROPIC_API_KEY="sua_chave_aqui"
```

### PowerShell (persistente para usuário atual)

```powershell
setx ANTHROPIC_API_KEY "sua_chave_aqui"
```

Abra um novo terminal após `setx`.

## Como executar no VS Code

1. Abra a pasta `spring-ai-claude-api` no VS Code.
2. Garanta que o terminal esteja com `ANTHROPIC_API_KEY` definida.
3. Execute:

```bash
mvn spring-boot:run
```

A aplicação sobe em `http://localhost:8080`.

## Exemplo de chamada

### POST

```http
POST /api/ask
Content-Type: application/json

{
  "question": "Explique o que é Java"
}
```

### curl

```bash
curl -X POST http://localhost:8080/api/ask \
  -H "Content-Type: application/json" \
  -d '{"question": "Explique o que é Java"}'
```

### Resposta esperada

```json
{
  "question": "Explique o que é Java",
  "answer": "Java é uma linguagem..."
}
```

## Estrutura

```text
spring-ai-claude-api/
├─ pom.xml
├─ README.md
└─ src/
   └─ main/
      ├─ java/
      │  └─ com/
      │     └─ example/
      │        └─ springai/
      │           ├─ SpringAiClaudeApiApplication.java
      │           ├─ controller/
      │           │  └─ AskController.java
      │           ├─ dto/
      │           │  └─ AskResponse.java
      │           └─ service/
      │              └─ AskService.java
      └─ resources/
         └─ application.properties
```
