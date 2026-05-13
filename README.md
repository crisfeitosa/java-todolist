# Todo List API

API REST para gerenciamento de tarefas desenvolvida com Spring Boot durante a trilha de Java da Rocketseat.

## Tecnologias

- Java 17
- Spring Boot 3.5
- Spring Data JPA
- H2 Database (in-memory)
- Lombok
- BCrypt (at.favre.lib)

## Como executar

### Pré-requisitos

- Java 17+
- Maven

### Rodando a aplicação

```bash
./mvnw spring-boot:run
```

A aplicação sobe em `http://localhost:8080`.

O console do H2 fica disponível em `http://localhost:8080/h2-console` com as credenciais:

- **JDBC URL:** `jdbc:h2:mem:todolist`
- **User:** `admin`
- **Password:** `admin`

## Endpoints

### Usuários

| Método | Rota      | Descrição         |
| ------ | --------- | ----------------- |
| POST   | `/users/` | Cadastrar usuário |

**Body — criar usuário:**

```json
{
  "name": "João Silva",
  "username": "joao",
  "password": "senha123"
}
```

---

### Tarefas

Todas as rotas de tarefas exigem autenticação **Basic Auth** (`username:password`).

| Método | Rota          | Descrição                             |
| ------ | ------------- | ------------------------------------- |
| POST   | `/tasks/`     | Criar tarefa                          |
| GET    | `/tasks/`     | Listar tarefas do usuário autenticado |
| PUT    | `/tasks/{id}` | Atualizar tarefa (somente o dono)     |

**Body — criar/atualizar tarefa:**

```json
{
  "title": "Minha tarefa",
  "description": "Descrição da tarefa",
  "startAt": "2026-05-14T08:00:00",
  "endAt": "2026-05-14T10:00:00",
  "priority": "ALTA"
}
```

> O campo `title` suporta no máximo 50 caracteres.  
> As datas `startAt` e `endAt` devem ser futuras, e `startAt` deve ser anterior a `endAt`.

## Estrutura do projeto

```
src/main/java/br/com/cristianofeitosa/todolist/
├── errors/         # Tratamento global de exceções
├── filter/         # Filtro de autenticação Basic Auth para /tasks
├── task/           # Entidade, repositório e controller de tarefas
├── user/           # Entidade, repositório e controller de usuários
└── utils/          # Utilitários (cópia de propriedades não nulas)
```
