package com.api1.crudtienda.user.controllers;

import com.api1.crudtienda.RequestResponseGeneric.RequestGeneric;
import com.api1.crudtienda.RequestResponseGeneric.ResponseGeneric;
import com.api1.crudtienda.articulo.models.ArticulosModel;
import com.api1.crudtienda.user.AuthRequest;
import com.api1.crudtienda.user.AuthService;
import com.api1.crudtienda.user.models.UserModel;
import com.api1.crudtienda.user.services.UserService;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {

    public final AuthService authService;
    public final UserService userService;

    public UserController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    /**
    @PostMapping("/register")
    public ResponseEntity<ResponseGeneric> createUser(@RequestBody RequestGeneric<UserModel> userModel){
        //return new ResponseEntity<>(userService.createUser((User) userModel.getData()), HttpStatus.OK);
    }
    */
}
