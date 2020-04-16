package com.gala.shop.controller;

import com.gala.shop.model.Role;
import com.gala.shop.model.TO.UserTO;
import com.gala.shop.model.User;
import com.gala.shop.service.UserService;
import com.gala.shop.util.TOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/shop/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserTO> getAll() {
        return service.getAll()
                .stream()
                .map(user -> TOUtil.asTO(user))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserTO get(@PathVariable int id) {
        return TOUtil.asTO(service.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity create(@RequestBody @Valid UserTO userTO) {
        service.save(TOUtil.createFrom(userTO, null, Role.ROLE_USER));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
