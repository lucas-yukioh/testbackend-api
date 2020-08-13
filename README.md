# Teste de backend
Repositório contendo api para teste de backend.

## Pré-requisitos
- Java 8
- Docker
- MySQL 8.0

Pode haver conflito na porta usada pelo MySQL na execução dos containers com o serviço do Windows (Porta 3306).

## Executando os containers

> - **Baixar o proejto**
```cmd
git clone https://github.com/lucas-yukioh/testebackend.git
```
> - **Fazer o build**
```cmd
mvnw clean install
```
> - **Montar as imagens**
```cmd
docker-compose build
```
> - **Executar os containers**
```cmd
docker-compose up
```

## Acessando a aplicação
A aplicação estará disponível através do caminho
```cmd
http://localhost:8080/api
```

### Requests

- Listar Cargos
```cmd
GET http://localhost:8080/api/cargos
```
- Listar Cargo por Id
```cmd
GET http://localhost:8080/api/cargos/{id}
```
- Inserir Cargo
```cmd
POST http://localhost:8080/api/cargos

Body
{
    "cargoNome": "Teste",
    "trilha": { 
        "id": 1 
    },
    "cargoMissao": "Teste"
}
```
- Atualizar Cargo
```cmd
PUT http://localhost:8080/api/cargos/{id}

Body
{
    "cargoNome": "Teste",
    "trilha": { 
        "id": 1 
    },
    "cargoMissao": "Teste"
}
```
- Deletar Cargo
```cmd
DELETE http://localhost:8080/api/cargos/{id}
```

- Listar Trilhas
```cmd
GET http://localhost:8080/api/trilhas
```
- Listar Trilha por Id
```cmd
GET http://localhost:8080/api/trilhas/{id}
```
- Inserir Trilha
```cmd
POST http://localhost:8080/api/trilhas

Body
{
    "trilhaNome": "Teste",
    "diretoria": "Teste",
    "missaoFormal": "Teste",
    "missaoAlternativa": "Teste"
}
```
- Atualizar Trilha
```cmd
PUT http://localhost:8080/api/trilhas/{id}

Body
{
    "trilhaNome": "Teste",
    "diretoria": "Teste",
    "missaoFormal": "Teste",
    "missaoAlternativa": "Teste"
}
```
- Deletar Trilha
```cmd
DELETE http://localhost:8080/api/trilhas/{id}
```
