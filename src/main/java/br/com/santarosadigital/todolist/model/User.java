package br.com.santarosadigital.todolist.model;

import br.com.santarosadigital.todolist.enumeration.ProfileEnum;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 4719283953262582703L;

    @NotNull
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String secret;
    @NotNull
    private ProfileEnum profile;

    public User() {
    }

    public User(Long id, String username, String secret, ProfileEnum profile) {
        this.id = id;
        this.username = username;
        this.secret = secret;
        this.profile = profile;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public ProfileEnum getProfile() {
        return profile;
    }

    public void setProfile(ProfileEnum profile) {
        this.profile = profile;
    }
}
