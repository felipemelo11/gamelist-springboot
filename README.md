# GameList API🎮🚀

Este projeto é uma API criada durante o **Intensivão Java Spring 19 DevSuperior**, evento organizado pela [DevSuperior](https://devsuperior.com "Site da DevSuperior").

A aplicação consiste em gerenciar uma lista de jogos, permitindo operações de leitura e movimentação de jogos entre listas.

## 📋 Funcionalidades:

- 🔍 **Listar jogos:** Recupera todos os jogos cadastrados.
- 🎮 **Buscar jogo por ID:** Obtém os detalhes de um jogo específico.
- 📋 **Listar listas de jogos:** Retorna todas as listas de jogos existentes.
- 🔄 **Movimentar jogos entre listas:** Permite mover jogos dentro de uma lista específica.

## 🛠️ Tecnologias utilizadas:
- Java Spring Boot 🛡️
- Banco de Dados MySQL 💾
- Docker 🐳
- Maven 🐘

## Estrutura do Projeto

O projeto segue a estrutura padrão para aplicações Spring Boot:

- `controller`: Controladores responsáveis por gerenciar as requisições.
- `service`: Contém a lógica de negócios.
- `repository`: Gerencia a interação com o banco de dados.
- `model`: Define as entidades do sistema.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter as seguintes ferramentas instaladas:

- **JDK 17 ou superior**
- **Maven**
- **Docker** (caso queira usar o banco de dados MySQL via container)

## 🚀 Configuração

1. Clone o repositório para sua máquina local:

```bash
git clone https://github.com/felipemelo11/gamelist-springboot.git
```

2. Navegue até o diretório do projeto:

```bash
cd gamelist-springboot
```

3. Configure o banco de dados no arquivo `application.properties` ou `application.yml` localizado em `src/main/resources`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3308/gamelist
spring.datasource.username=myuser
spring.datasource.password=secret
```

4. **(Opcional) Configuração via Docker**

Caso prefira rodar o banco de dados MySQL e o Adminer via Docker, utilize o `docker-compose.yml` fornecido no projeto:

```bash
docker-compose up -d
```

### Arquivo `docker-compose.yml`:

```yaml
services:
  mysql-docker:
    image: 'mysql:latest'
    container_name: dev-mysql
    environment:
      - 'MYSQL_DATABASE=gamelist'
      - 'MYSQL_PASSWORD=secret'
      - 'MYSQL_ROOT_PASSWORD=verysecret'
      - 'MYSQL_USER=myuser'
    ports:
      - '3308:3306'
    volumes:
      - ./.data/mysql/data:/var/lib/mysql
    networks:
      - dev-network

  adminer:
    image: adminer
    container_name: adminer
    restart: always
    ports:
      - "5050:8080"
    networks:
      - dev-network

networks:
  dev-network:
    driver: bridge
```

Após rodar o comando acima, o banco de dados estará disponível na porta **3308**, e o Adminer poderá ser acessado via navegador em `http://localhost:5050`.

5. Compile e execute a aplicação:

```bash
mvn spring-boot:run
```

## 📝 Endpoints principais:

### Jogos

- **GET /games**: Retorna a lista de todos os jogos.
- **GET /games/{id}**: Retorna os detalhes de um jogo específico.

### Listas de Jogos

- **GET /lists**: Retorna a lista de todas as listas de jogos.
- **GET /lists/{listId}/games**: Retorna os jogos de uma lista específica.
- **POST /lists/{listId}/replacement**: Move jogos dentro de uma lista específica.

## Exemplos de Requisição

### Listar jogos

**GET /games**

Resposta: Uma lista de jogos.

### Buscar jogo por ID

**GET /games/{id}**

Resposta: Detalhes do jogo.

### Movimentar jogo entre listas

**POST /lists/{listId}/replacement**

Corpo da requisição:

```json
{
  "sourceIndex": 0,
  "destinationIndex": 1
}
```

## Testes

O projeto inclui testes básicos para verificar a funcionalidade dos endpoints. Para executá-los, use o comando:

```bash
mvn test
```

## Autor
Felipe de Melo Brito

https://www.linkedin.com/in/felipemelo1106


