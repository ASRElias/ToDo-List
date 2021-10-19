#!/bin/bash

# Create Users to Test
curl --header "Content-Type: application/json" \
--request POST \
--data '{ "username" : "principal", "secret" : "supersecret", "profile" : "ADMINISTRATOR" }' \
http://localhost:8080/user
curl --header "Content-Type: application/json" \
--request POST \
--data '{ "username" : "manager", "secret" : "supersecret", "profile" : "MANAGER" }' \
http://localhost:8080/user
curl --header "Content-Type: application/json" \
--request POST \
--data '{ "username" : "operator", "secret" : "supersecret", "profile" : "OPERATOR" }' \
http://localhost:8080/user

# Insert Tasks to Search
curl --header "Content-Type: application/json" \
--header "xToken: XPTO" \
--request POST \
--data '{ "userId" : "principal", "taskAbstract" : "Tarefa A do usuário principal", "taskDescription" : "Tarefa pendente", "status" : "PENDING"  }' \
http://localhost:8080/v1/api-todo/todo/
curl --header "Content-Type: application/json" \
--header "xToken: XPTO" \
--request POST \
--data '{ "userId" : "principal", "taskAbstract" : "Tarefa B do usuário principal", "taskDescription" : "Tarefa realizada", "status" : "COMPLETED"  }' \
http://localhost:8080/v1/api-todo/todo/
curl --header "Content-Type: application/json" \
--header "xToken: XPTO" \
--request POST \
--data '{ "userId" : "principal", "taskAbstract" : "Tarefa C do usuário principal", "taskDescription" : "Tarefa pendente", "status" : "PENDING"  }' \
http://localhost:8080/v1/api-todo/todo/
curl --header "Content-Type: application/json" \
--header "xToken: XPTO" \
--request POST \
--data '{ "userId" : "manager", "taskAbstract" : "Tarefa A do usuário manager", "taskDescription" : "Tarefa pendente", "status" : "PENDING"  }' \
http://localhost:8080/v1/api-todo/todo/
curl --header "Content-Type: application/json" \
--header "xToken: XPTO" \
--request POST \
--data '{ "userId" : "manager", "taskAbstract" : "Tarefa B do usuário manager", "taskDescription" : "Tarefa realizada", "status" : "COMPLETED"  }' \
http://localhost:8080/v1/api-todo/todo/
curl --header "Content-Type: application/json" \
--header "xToken: XPTO" \
--request POST \
--data '{ "userId" : "manager", "taskAbstract" : "Tarefa C do usuário manager", "taskDescription" : "Tarefa pendente", "status" : "PENDING"  }' \
http://localhost:8080/v1/api-todo/todo/
curl --header "Content-Type: application/json" \
--header "xToken: XPTO" \
--request POST \
--data '{ "userId" : "manager", "taskAbstract" : "Tarefa D do usuário manager", "taskDescription" : "Tarefa realizada", "status" : "COMPLETED"  }' \
http://localhost:8080/v1/api-todo/todo/
curl --header "Content-Type: application/json" \
--header "xToken: XPTO" \
--request POST \
--data '{ "userId" : "operator", "taskAbstract" : "Tarefa A do usuário operator", "taskDescription" : "Tarefa realizada", "status" : "COMPLETED"  }' \
http://localhost:8080/v1/api-todo/todo/
curl --header "Content-Type: application/json" \
--header "xToken: XPTO" \
--request POST \
--data '{ "userId" : "operator", "taskAbstract" : "Tarefa B do usuário operator", "taskDescription" : "Tarefa pendente", "status" : "PENDING"  }' \
http://localhost:8080/v1/api-todo/todo/
curl --header "Content-Type: application/json" \
--header "xToken: XPTO" \
--request POST \
--data '{ "userId" : "operator", "taskAbstract" : "Tarefa C do usuário operator", "taskDescription" : "Tarefa realizada", "status" : "COMPLETED"  }' \
http://localhost:8080/v1/api-todo/todo/
curl --header "Content-Type: application/json" \
--header "xToken: XPTO" \
--request POST \
--data '{ "userId" : "operator", "taskAbstract" : "Tarefa D do usuário operator", "taskDescription" : "Tarefa pendente", "status" : "PENDING"  }' \
http://localhost:8080/v1/api-todo/todo/



