# API Gerenciador de Membros

Este é um projeto de API simples para um Gerenciador de Membros, desenvolvido com Spring Boot e MongoDB. A API oferece operações básicas para criar, listar, atualizar e excluir membros.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas antes de começar:

- [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Gradle](https://gradle.org/install/)
- [Docker](https://www.docker.com/get-started)

## Configuração do Projeto

Clone o repositório:

```bash
git clone https://github.com/seu-usuario/gerenciador-de-membros.git
cd gerenciador-de-membros
```

## Executando a API Localmente

1. **Construir o Projeto:**

   ```bash
   ./gradlew build
   ```

2. **Executar o Contêiner Docker:**

   ```bash
   docker build -t gerenciador-membros-app .
   docker run -p 8080:8080 gerenciador-membros-app
   ```

   O aplicativo estará disponível em [http://localhost:8080](http://localhost:8080).

3. **Documentação da API (Swagger):**

   Acesse a documentação da API em [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

## Endpoints da API

### 1. Cadastrar Membro

- **Endpoint:** `POST /membros`
- **Payload de Exemplo:**
  ```json
  {
    "name": "John Doe",
    "description": "Membro ativo",
    "age": 25
  }
  ```

### 2. Listar Membros

- **Endpoint:** `GET /membros`

### 3. Atualizar Membro

- **Endpoint:** `PUT /membros/{id}`
- **Payload de Exemplo:**
  ```json
  {
    "name": "John Doe Jr.",
    "description": "Membro ativo e engajado",
    "age": 26
  }
  ```

### 4. Excluir Membro

- **Endpoint:** `DELETE /membros/{id}`

## Contribuindo

Sinta-se à vontade para contribuir para este projeto abrindo problemas ou enviando pull requests. Sua colaboração é bem-vinda!

## Licença

Este projeto é distribuído sob a licença [MIT](LICENSE). Veja o arquivo [LICENSE](LICENSE) para obter mais detalhes.

---
