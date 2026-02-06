## 🔐 Auth API – Spring Boot + JWT

API de autenticação desenvolvida com Spring Boot utilizando JWT (JSON Web Token) para controle de acesso, com foco em boas práticas de segurança e arquitetura REST.

Este projeto faz parte do meu portfólio de estudos em back-end com Java e Spring Security.

## 🚀 Funcionalidades

Cadastro de usuários

- Login com geração de token JWT

- Autenticação stateless

- Proteção de rotas com Spring Security

- Controle de acesso por role (USER, ADMIN)

- Endpoint autenticado para obter usuário logado (/users/me)

- Banco de dados em memória (H2) para desenvolvimento

## 🛠️ Tecnologias Utilizadas

- Java 17+

- Spring Boot

- Spring Security

- Spring Data JPA

- JWT

- H2 Database

- Maven

## 🔑 Endpoints
### 📌 Cadastro de usuário

```http
POST /auth/register
```
### Body (JSON):
```json
{
  "username": "teste",
  "password": "123"
}
```

## 🔵 Login
#### POST /auth/login

#### Body (JSON):

```json
{
  "username": "teste",
  "password": "123"
}
```

#### Resposta:

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```
## 🔒 Usuário autenticado

```http
{
  GET /users/me
}
```

#### Header obrigatório:

```http
Authorization: Bearer SEU_TOKEN_AQUI

```

#### Resposta:

```yaml
Usuário logado: teste

```
## 🧪 Banco de dados H2

Console disponível em:
```bash
http://localhost:8080/h2-console
```

Configuração padrão:

- JDBC URL: jdbc:h2:mem:testdb

- User: sa

- Password: (vazio)

##  🧠 Aprendizados com o projeto

- Funcionamento do Spring Security

- Autenticação stateless com JWT

- Filtros de segurança personalizados

- Criptografia de senhas com BCrypt

- Integração entre Controller, Service e Repository

- Boas práticas de organização de API REST



