# 🎵 MusicPub

<p align="center">
  <strong>Plataforma backend para conectar artistas, bandas e músicos independentes a estabelecimentos que desejam contratar apresentações musicais.</strong>
</p>

<p align="center">
  <a href="#funcionalidades">Funcionalidades</a> •
  <a href="#tecnologias">Tecnologias</a> •
  <a href="#arquitetura">Arquitetura</a> •
  <a href="#estrutura">Estrutura do Projeto</a> •
  <a href="#execucao">Execução</a> •
  <a href="#endpoints">Endpoints</a> •
  <a href="#roadmap">Roadmap</a>
</p>

---

# 📖 Sobre o Projeto

O **MusicPub** é uma API REST desenvolvida com **Java 21** e **Spring Boot** que tem como objetivo conectar músicos e estabelecimentos interessados em contratar apresentações musicais.

A plataforma funciona como um ambiente centralizado onde artistas podem divulgar seus perfis profissionais e estabelecimentos podem encontrar talentos para eventos, bares, restaurantes, pubs e casas de show.

O projeto está sendo desenvolvido com foco em boas práticas de backend e arquitetura de software, tendo como principais características:

* Desenvolvimento Backend com Java e Spring Boot
* APIs REST
* Spring Security e autenticação JWT
* Validação de payloads usando Spring Validation
* Tratamento personalizado de exceções
* Banco de dados relacional
* Modelagem de domínio
* Arquitetura em camadas
* Dockerização do banco de dados via docker compose
* Controle de acesso baseado em papéis (Roles)
* Persistência de dados com JPA/Hibernate
* Versionamento com Git

---

<h1 id ="funcionalidades">🚀 Funcionalidades</h2>

## ✅ Implementadas

### Autenticação e Autorização

* Cadastro de artistas
* Cadastro de estabelecimentos
* Login com autenticação JWT
* Criptografia de senhas
* Controle de acesso baseado em Roles
* Autenticação Stateless

### Gerenciamento de Perfis Artísticos

* Buscar todos os artistas
* Buscar artista por ID
* Atualizar perfil artístico
* Remover perfil artístico (Administrador)
* Controle de propriedade do perfil

### Gerenciamento de Perfis de Estabelecimentos

* Buscar todos os estabelecimentos
* Buscar estabelecimento por ID
* Atualizar perfil do estabelecimento
* Remover estabelecimento (Administrador)
* Controle de propriedade do perfil

### Segurança

* Spring Security
* JWT Authentication
* Endpoints protegidos
* Controle de acesso com `@PreAuthorize`
* Permissões por perfil de usuário
* Validações de autorização em nível de recurso

### Qualidade de Código

* DTO Pattern
* Arquitetura em camadas
* Separação de responsabilidades
* Validações com Bean Validation
* Tratamento centralizado de regras de negócio
* Persistência com Spring Data JPA

---

## 🚧 Em Construção

### Oportunidades Musicais

* Criação de oportunidades/eventos
* Edição de oportunidades
* Encerramento de oportunidades
* Listagem e filtros
* Controle de vagas disponíveis

### Sistema de Candidaturas

* Envio de candidatura para eventos
* Aprovação de artistas
* Rejeição de candidaturas
* Cancelamento de candidaturas
* Controle de candidaturas duplicadas

### Regras de Negócio Avançadas

* Limite de vagas por evento
* Validação de status de oportunidade
* Gestão de aprovações
* Fluxo completo de contratação



### Documentação

* Swagger/OpenAPI
* Documentação completa dos endpoints

---

<h1 id ="tecnologias">💻 Tecnologias</h2>

## Backend

* Java 21
* Spring Boot
* Spring Web
* Spring Security
* Spring Data JPA
* Hibernate
* Maven

## Banco de Dados

* PostgreSQL

## Segurança

* JWT (JSON Web Token)
* Password Encryption (BCrypt)
* Role-Based Access Control (RBAC)

## Infraestrutura
* Docker
* Docker Compose
* Configuração por variáveis de ambiente

## Versionamento

* Git
---

<h1 id ="arquitetura">🏗️ Arquitetura</h2>

O projeto segue o padrão de arquitetura em camadas, promovendo separação de responsabilidades e facilitando manutenção e escalabilidade.

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

Principais conceitos utilizados:

* DTOs para comunicação externa
* Entidades JPA para persistência
* Repositories para acesso a dados
* Services para regras de negócio
* Security Layer para autenticação e autorização
* Exception Handling centralizado

---
<h1 id ="estrutura">📂 Estrutura do Projeto</h2>

```text
src/main/java/com/pedrohlopes/musicPub

├── config
├── controller
├── dto
├── enums
├── exception
├── handler
├── model
├── repository
├── service
└── MusicPubApplication.java
```

---

# 🗄️ Modelo de Domínio

## User

Responsável pela autenticação dos usuários.

Tipos suportados:

* ARTIST
* ESTABLISHMENT
* ADMIN

## ArtistProfile

Representa músicos, bandas e artistas independentes.

## EstablishmentProfile

Representa bares, restaurantes, pubs, casas de show e organizadores de eventos.

## Próximas Entidades

* Opportunity
* Application

---

<h1 id ="execucao">🚀 Execução</h2>

## Clonando o Projeto

```bash
git clone https://github.com/seu-usuario/musicpub.git
```

```bash
cd musicpub
```

## Configurando Banco de Dados e Chave JWT

O arquivo .env example traz todas as variáveis de ambiente que necessitam de configuração:

```properties
DB_POSTGRES_NAME=nome-do-banco-postgress
DB_POSTGRES_USERNAME=usuario-para-acesso-ao-banco
DB_POSTGRES_PASSWORD=senha-para-acesso-ao-banco

JWT_EXPIRATION=tempo-de-expiração-chave-jwt
JWT_KEY=chave-jwt
```

## Executando a Aplicação

### Subindo o Banco de Dados

Execute: 

```bash
docker compose up -d
```

Verifique se o container entrou em execução:

```bash
docker ps
```

### Iniciando Aplicação

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```

---

<h1 id ="endpoints">📍 Endpoints da API</h2>

## Autenticação

| Método | Endpoint                        |
| ------ | ------------------------------- |
| POST   | /v1/auth/register/artist        |
| POST   | /v1/auth/register/establishment |
| POST   | /v1/auth/login                  |

---

### POST /v1/auth/login

#### Requisição

```json
{
  "email": "user@email.com",
  "password": "password123"
}
```

#### Resposta

```json
{
  "token": "jwt-token"
}
```

---

## Artistas

| Método | Endpoint                |
| ------ | ----------------------- |
| GET    | /v1/artist-profile      |
| GET    | /v1/artist-profile/{id} |
| PATCH  | /v1/artist-profile/{id} |
| DELETE | /v1/artist-profile/{id} |

---

## Estabelecimentos

| Método | Endpoint                       |
| ------ | ------------------------------ |
| GET    | /v1/establishment-profile      |
| GET    | /v1/establishment-profile/{id} |
| PATCH  | /v1/establishment-profile/{id} |
| DELETE | /v1/establishment-profile/{id} |

---

<h1 id ="segurança">🔒 Segurança</h2>

A aplicação utiliza autenticação baseada em JWT.

Fluxo:

1. Usuário realiza login.
2. API gera um token JWT.
3. Cliente envia o token no header Authorization.
4. Spring Security valida o token.
5. O acesso aos recursos é liberado conforme a Role do usuário.

Exemplo:

```http
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

Também são utilizadas regras de autorização baseadas em:

* Ownership Validation
* Role-Based Access Control
* Method Security com `@PreAuthorize`


---

<h1 id ="roadmap">🛣️ Roadmap</h2>

## Próximas versões

* [ ] CRUD de oportunidades
* [ ] Sistema de candidaturas
* [ ] Estilos musicais
* [ ] Swagger/OpenAPI
* [ ] Docker Compose
* [ ] Flyway
* [ ] Testes unitários
* [ ] Testes de integração

---
