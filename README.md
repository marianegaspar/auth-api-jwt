## 🔐 Auth API – Spring Boot + JWT

API de autenticação desenvolvida com Spring Boot utilizando JWT (JSON Web Token) para controle de acesso, com foco em boas práticas de segurança e arquitetura REST.

Este projeto faz parte do meu portfólio de estudos em back-end com Java, abordando autenticação stateless, Spring Security e persistência de dados com PostgreSQL.

## 🚀 Funcionalidades

Cadastro de usuários

- Cadastro de usuários

- Login com geração de token JWT

- Autenticação stateless

- Proteção de rotas com Spring Security

- Controle de acesso por roles (USER, ADMIN)

- Endpoint autenticado para obter o usuário logado (/users/me)

- Persistência de dados com PostgreSQL

- Banco de dados executado via Docker

## 🛠️ Tecnologias Utilizadas

- Java 17+

- Spring Boot

- Spring Security

- Spring Data JPA

- PostgreSQL
  
- Docker & Docker Compose

- Maven

## 🐘 Banco de Dados (PostgreSQL + Docker)
O banco de dados é executado via Docker, garantindo isolamento e facilidade de setup.

### Subir o banco de dados

```bash
docker-compose up -d
```
Configuração:

- Banco: authdb

- Usuário: authuser

- Porta: 5432

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

## ▶️ Como executar o projeto

```bash
# Clonar o repositório
git clone git@github.com:marianegaspar/auth-api-jwt.git

# Entrar no projeto
cd auth-api-jwt

# Subir o banco de dados
docker-compose up -d

# Rodar a aplicação
./mvnw spring-boot:run
```

##  🧠 Aprendizados com o projeto

- Funcionamento do Spring Security

- Autenticação stateless com JWT
  
- Implementação de filtros de segurança personalizados

- Criptografia de senhas com BCrypt

- Integração entre Controller, Service e Repository

- Integração Spring Boot + PostgreSQL

- Uso de Docker para infraestrutura de banco de dados

- Boas práticas de organização de APIs REST


