# Desafio de Validação de Senhas - API Spring Boot

Esta é uma solução para o desafio de validação de senhas, desenvolvida como parte de um processo seletivo para Desenvolvedor Junior. A aplicação expõe um endpoint REST que verifica se uma senha atende a critérios rigorosos de segurança.

##  Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot 3.x**
- **Maven**
- **JUnit 5** (Testes Unitários)

##  Critérios de Validação
A senha é considerada válida se possuir:
1. Nove ou mais caracteres.
2. Ao menos 1 dígito.
3. Ao menos 1 letra minúscula.
4. Ao menos 1 letra maiúscula.
5. Ao menos 1 caractere especial (`!@#$%^&*()-+`).
6. **Não possuir caracteres repetidos** (Case-sensitive).
7. Não possuir espaços em branco.

##  Arquitetura e Boas Práticas
- **SOLID:** Aplicação do Princípio de Responsabilidade Única (SRP).
- **Clean Code:** Nomenclatura de métodos e variáveis clara e semântica.
- **DTO Pattern:** Uso de `Records` para transferência de dados entre camadas.
- **Injeção de Dependência:** Desacoplamento entre o Controller e o Service.
- **Coesão e Acoplamento:** Lógica de negócio isolada na camada de serviço, facilitando a manutenção e testes.
- **Utilização de log:** Utilização de log no código para visualizar tipos de erros no terminal.  

## Como Testar a API
### Estar na raíz de teste
- .\mvnw test

## Como rodar a API
- DesafioItauApplication - É onde está nosso SpringBootApplication que vai inicializar tudo o que foi construído.
- Precisa estar na raiz que é a pasta: cd DesafioItau
- E roda: .\mvnw spring-boot:run

### 1. Validar Senha (POST)
### Abrir o url no postman para testar
**URL:** `http://localhost:8080/v1/password/validate`  
**Body (JSON):**
```json
{
  "password": "Ps2@fghjk"
}
```
### Resposta:
**Body (JSON):**
````json
{
  "message": "Senha válida: true",
  "isValid": true
}
````
### 2. Teste de Funcionamento (GET)
**URL:** `http://localhost:8080/v1/password/hello`  
**Body (Text):**
```text
Olá mundo. 
```
