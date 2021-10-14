package br.com.santarosadigital.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class Diagnostics {
    @GetMapping(path = "/healthcheck", produces = { "application/json" })
    public String healthcheck() {
        return "{ \"status\": \"UP\" }";
    }

    @GetMapping(path = "/info", produces = { "application/json" })
    public String info() {
        return "{ \"info\": \"API TODO LIST\" }";
    }

}
