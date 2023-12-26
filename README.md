Claro! Vamos atualizar o README com as últimas informações:

```markdown
# Gerenciador de Membros API

## Descrição
Este projeto é uma API para gerenciar membros, fornecendo endpoints para criar, listar, atualizar e excluir membros.

## Tecnologias Utilizadas
- Spring Boot
- MongoDB
- Swagger

## Configuração do Swagger
A documentação da API pode ser acessada através do Swagger. Após iniciar a aplicação, acesse `http://localhost:8080/swagger-ui.html` para explorar os endpoints disponíveis.

## Como Rodar o Projeto
Certifique-se de ter o Java 17 e o MongoDB instalados em sua máquina. Em seguida, execute os seguintes comandos:

```bash
./gradlew build
./gradlew bootRun
```

A aplicação estará disponível em `http://localhost:8080`.

## Endpoints
- **GET /membros**: Lista todos os membros.
- **GET /membros/{id}**: Obtém um membro pelo ID.
- **POST /membros**: Cria um novo membro.
- **PUT /membros/{id}**: Atualiza um membro existente.
- **DELETE /membros/{id}**: Exclui um membro pelo ID.

## Exemplos de Requisições

### GET /membros
Retorna a lista de membros.

```bash
curl http://localhost:8080/membros
```

### POST /membros
Cria um novo membro.

```bash
curl -X POST -H "Content-Type: application/json" -d '{"name": "John Doe", "description": "Lorem ipsum", "age": 25}' http://localhost:8080/membros
```

### PUT /membros/{id}
Atualiza um membro existente.

```bash
curl -X PUT -H "Content-Type: application/json" -d '{"name": "Updated Name", "description": "Updated Description", "age": 30}' http://localhost:8080/membros/{id}
```

### DELETE /membros/{id}
Exclui um membro pelo ID.

```bash
curl -X DELETE http://localhost:8080/membros/{id}
```

## Testes
Os testes unitários são fornecidos para garantir a funcionalidade correta da aplicação. Execute os seguintes comandos para executar os testes:

```bash
./gradlew test
```

## Contribuindo
Contribuições são bem-vindas! Se você encontrar problemas ou tiver sugestões, abra uma issue ou envie um pull request.

```
