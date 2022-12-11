package com.example.wardrobeserver.controllers;

import com.example.wardrobeserver.domain.Outfit;
import com.example.wardrobeserver.domain.User;
import com.example.wardrobeserver.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping(value = "/user/all")
    public ResponseEntity hello() {
        try {
            return ResponseEntity.ok(userService.getUsers());
        }catch (IllegalArgumentException e)
        {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping(value = "/user/reg")
    public ResponseEntity addUser(@RequestBody User user) {
        try {
            userService.regUser(user);

            return ResponseEntity.ok(user);
        }catch (IllegalArgumentException e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/user/auth")
    public ResponseEntity authUser(@RequestBody User user) {
        try {
            user = userService.authUser(user);

            return ResponseEntity.ok(user);
        }catch (IllegalArgumentException e)
        {
            return new ResponseEntity<>("Wrong login or password.", HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping("/user/getUserById/{id}")
    public ResponseEntity getUserId(@RequestParam long id) {
        try {
            log.info("" + id);
            return ResponseEntity.ok(userService.getById(id));
        }catch (NoSuchElementException e)
        {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/collections")
    public List<Outfit> getCollections(@RequestParam long id) {
        return new ArrayList<>();
    }

}




