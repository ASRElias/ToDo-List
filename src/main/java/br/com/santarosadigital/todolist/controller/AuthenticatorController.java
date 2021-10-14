package br.com.santarosadigital.todolist.controller;

import br.com.santarosadigital.todolist.model.User;
import br.com.santarosadigital.todolist.repository.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sun.istack.NotNull;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthenticatorController {

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public String post(@Validated @NotNull @RequestBody User user) {

        User userToValidate = userRepository.findByUserName(user.getUsername());

        if (userToValidate != null &&
                userToValidate.getSecret().equals(user.getSecret())) {
            return JWT.create()
                    .withSubject(user.getUsername())
                    .withIssuer("localhost:8080")
                    .withIssuedAt(new Date())
                    .withExpiresAt(Date.from(LocalDateTime.now().plusMinutes(15L).atZone(ZoneId.systemDefault()).toInstant()))
                    .sign(Algorithm.HMAC256("secret"));
        } else {
            return "Usuário e/ou senha inválidos";
        }
    }

}
