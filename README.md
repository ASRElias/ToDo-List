
# TODO LIST API

This document contains all instructions to run
locally all api services. The demo project can be found at [github.com][github]

## External Libraries

* Spring Web
* JPA
* H2
* Lombok
* JUnit
* JWT

## What You Need

* JAVA 11 or later
* Gradle 4+ or Maven 3.2+

## Running The API
mvn install

mvn spring-boot:run

sh init.sh

## Testing The API

Receber diagnósticos
```shell
curl http://localhost:8080/v1/api-todo/health

curl http://localhost:8080/v1/api-todo/info
```

Receber token para operações

* principal
* manager
* operator

```json
{
  "username" : "manager",
  "secret" : "supersecret"
}
```
```shell
 curl --header "Content-Type: application/json" --request POST --data '{ "username" : "manager", "secret" : "supersecret" }' http://localhost:8080/auth
```


Obter lista
```shell
curl --header "x-token: XPTO" http://localhost:8080/v1/api-todo/todo

curl --header "x-token: XPTO" http://localhost:8080/v1/api-todo/todo/{id}
```

Obter lista por situação
* COMPLETED
* PENDING
```shell
curl --header "x-token: XPTO" http://localhost:8080/v1/api-todo/todo/status/{status}
```

Incluir uma tarefa

```json
{
   "userId":"principal",
   "taskAbstract":"Tarefa A do usuário principal",
   "taskDescription":"Tarefa pendente",
   "status":"PENDING"
}
```
```shell
curl --header "Content-Type: application/json" \
--request POST \
--data '{ "userId" : "principal", "taskAbstract" : "Tarefa A do usuário principal", "taskDescription" : "Tarefa pendente", "status" : "PENDING"  }' \
http://localhost:8080/v1/api-todo/todo/
```

Modificar uma tarefa
```json
{
  "id":1,
  "taskAbstract":"Tarefa C do usuário operator",
  "taskDescription":"Tarefa realizada",
  "status":"COMPLETED"
}
```
```shell
curl --header "Content-Type: application/json" \
--request PUT \
--data '{  "id" : 1, "taskAbstract" : "Tarefa A do usuário principal", "taskDescription" : "Tarefa realizada", "status" : "COMPLETED"  }' \
http://localhost:8080/v1/api-todo/todo/
```

Apagar uma tarefa
* ID
```shell
curl --header "Content-Type: application/json" \
--request DELETE \
http://localhost:8080/v1/api-todo/todo/{id}
```

[github]: https://github.com/ASRElias/ToDo-List