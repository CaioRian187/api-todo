# 📝 Todo List API

Uma API REST simples e eficiente para gerenciamento de tarefas (To-do List), desenvolvida em **Java** com **Spring Boot**. O principal objetivo deste projeto foi aplicar os conceitos da **Arquitetura Hexagonal (Ports and Adapters)** para garantir o desacoplamento do núcleo de negócios da aplicação.

---

## 🏗️ Arquitetura do Projeto

Este projeto foi desenhado seguindo a **Arquitetura Hexagonal**, dividindo a aplicação em camadas bem definidas:

* **Domínio (Domain):** Contém as entidades de negócio (`Todo`) e as regras fundamentais da aplicação. É totalmente independente de frameworks.
* **Portas (Ports):** Interfaces que definem como o mundo externo interage com o domínio (`TodoServicePort`) e como o domínio interage com recursos externos.
* **Adaptadores (Adapters):** Implementações tecnológicas específicas que se conectam às portas. 
    * **Driving Adapters:** Controladores HTTP (`TodoController`) que expõem a API para o cliente.
    * **Driven Adapters:** Persistência de dados (`TodoEntity`, repositórios) que lidam com o banco de dados.

O uso do **ModelMapper** garante a conversão limpa entre a entidade de domínio e a entidade de persistência.

---

## 🛠️ Tecnologias e Dependências

* **Java 17+**
* **Spring Boot 3.x**
* **Spring Web:** Para criação dos endpoints RESTful.
* **Spring Data JPA:** Para abstração da camada de persistência.
* **H2 Database:** Banco de dados em memória para facilidade de desenvolvimento e testes rápidos.
* **Lombok:** Para redução de código boilerplate (Getters, Setters, Construtores).
* **ModelMapper:** Para mapeamento e conversão de objetos entre as camadas.

---

## 🔌 API Endpoints

A URL base da aplicação é: `http://localhost:8080/todos`

### 🗺️ Resumo dos Endpoints

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/todos` | Cria uma nova tarefa. |
| `GET` | `/todos` | Lista todas as tarefas cadastradas. |
| `GET` | `/todos/{id}` | Busca uma tarefa específica pelo ID. |
| `PUT` | `/todos/concluir/{id}` | Marca uma tarefa específica como concluída. |
| `DELETE` | `/todos/{id}` | Remove uma tarefa pelo ID. |

---

### 📥 Detalhes das Requisições

#### 1. Criar Todo
* **Método:** `POST`
* **Corpo da Requisição (JSON):**
```json
{
  "descricao": "Descrição do Todo",
  "feita": false
}
```
* **Resposta esperada: 201 Created**
```json
{
"id": 1,
  "descricao": "Estudar Arquitetura Hexagonal",
  "feita": false
}
```

#### 2. Buscar Todos
* **Método:** `GET`
* **Endpoint: /todos**
* **Request Body (JSON):**
* **Resposta esperada: 200 Ok**
```json
[
  {
    "id": 1,
    "descricao": "Estudar Arquitetura Hexagonal",
    "feita": false
  },
  {
    "id": 2,
    "descricao": "Estudar Spring Boot",
    "feita": false
  }
]
```

#### 3. Buscar Todo por ID
* **Método:** `GET`
* **Endpoint: /todos/{id} (Exemplo: /todos/1)**
* **Resposta esperada: 200 Ok**
```json
{
    "id": 1,
    "descricao": "Estudar Arquitetura Hexagonal",
    "feita": false
}
```

#### 4. Concluir Todo
* **Método:** `PUT`
* **Endpoint: /todos/concluir/{id} (Exemplo: /todos/concluir/1)**
* **Resposta esperada: 200 Ok**
```json
{
  "id": 1,
  "descricao": "Estudar Arquitetura Hexagonal",
  "feita": true
}
```

#### 5. Deletar Todo
* **Método:** `DELETE`
* **Endpoint: /todos/{id} (Exemplo: /todos/1)**
* **Resposta esperada: 200 Ok**
* * **Request Body: Nenhum**
