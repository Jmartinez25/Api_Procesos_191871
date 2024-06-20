package com.api1.crudtienda.user.models;

import com.api1.crudtienda.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class UserModel extends UserDetailsServiceAutoConfiguration {

    @Id
    @GeneratedValue
    private long id;

    private String fullName;

    private String document;

    private String documentType;

    private LocalDate birthday;


    private String phoneNumber;


    private String email;


    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }


}
