## Exemplo de aplicação em Kotlin + Spring Boot + Mongodb + Docker:

* Exemplo de aplicação em Kotlin, Spring Boot, Mongodb e Docker aprendidos no canal do amigoscode.
* Link para o vídeo: https://www.youtube.com/watch?v=ssj0CGxv60k

### Banco NoSQL:
* Um banco NoSQL é um tipo de banco de dados que não segue o modelo relacional tradicional. Em vez disso, ele usa outras estruturas de dados para armazenar informações. Esses bancos são ideais para aplicações que precisam lidar com grandes volumes de dados e requerem alta escalabilidade, disponibilidade e desempenho. Eles são projetados para trabalhar com dados não estruturados, sem esquemas fixos, como documentos, gráficos e dados de séries temporais

### Mongodb:
* O MongoDB é um banco de dados NoSQL de código aberto, orientado a documentos e baseado em JSON. Ele é um dos bancos NoSQL mais populares e amplamente utilizados no mercado. O MongoDB oferece alta escalabilidade, desempenho e flexibilidade, permitindo que as empresas gerenciem grandes volumes de dados de forma eficiente. Ele é capaz de lidar com dados não estruturados e sem esquemas fixos, o que o torna ideal para aplicações web e móveis modernas. Além disso, o MongoDB é altamente seguro e oferece recursos avançados de replicação, balanceamento de carga e recuperação de desastres.

### Collections:
* Mongo armazena documents (rows) em collections (table).
* Os documents são parecidos com objetos json:
{
    name: "Gabriel Alves",
    age: 27
}

### Documents:
* MongoDB armazena registros de dados como documents BSON. BSON é uma representação binária de documents JSON.

### BSON Types:
#### Type / Alias:
* Double / double
* String / string
* Object / object
* Array / array
* Binary data / binData
* ObjectId / objectId
* Boolean / bool
* Date / date
* Null / null
* Regular Expression / regex
* Javascript / javascript
* 32 Big integer / Int
* 64 bit Integer / long
* Decimal128 / decimal
* Min and Max Key / minKey | maxKey

### Definindo a Model:
* Criadas as classes Model em [models](src%2Fmain%2Fkotlin%2Fcom%2Fgabrieldragone%2Fspringmongodb%2Fmodels).
* Perceba que realizamos anotações apenas na classe [Estudante.kt](src%2Fmain%2Fkotlin%2Fcom%2Fgabrieldragone%2Fspringmongodb%2Fmodels%2FEstudante.kt).

### Service:
* Na Service, teremos exemplos utilizando Repository e utilizando MongoTemplate.

### Bônus:
* Criei a classe de [ExceptionHandler.kt](src%2Fmain%2Fkotlin%2Fcom%2Fgabrieldragone%2Fspringmongodb%2Fexceptions%2FExceptionHandler.kt) para tratar os erros de maneira mais "bonita", isso faz com que nosso sistema não retorne stacks de erro, revelando assim estruturas do nosso código.

### Rodando a aplicação:
* Abrir o Docker Desktop.
* Digitar no terminal e pasta raiz: docker-compose up. Ou executar através do [docker-compose.yml](docker-compose.yml)
* Executar a aplicação através de [SpringMongodbApplication.kt](src%2Fmain%2Fkotlin%2Fcom%2Fgabrieldragone%2Fspringmongodb%2FSpringMongodbApplication.kt)
* Acessar o mongo-express através do link: http://localhost:8081/
* Acessar o SWAGGER para realizar as requisições através do link: http://localhost:8080/swagger-ui/index.html#/