package com.phonebook.controller;

import com.phonebook.exceptions.NotFoundException;
import com.phonebook.model.User;
import com.phonebook.repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {
    private final UserRepo userRepo;

    @Autowired
    public MainController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable(value = "id") User user) {
        return user;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PutMapping
    public User update(@PathVariable("id") User userFromDb, @RequestBody User user) {
        User users = userRepo.findById(user.getId()).orElseThrow(NotFoundException::new);
        BeanUtils.copyProperties(users, userFromDb, "id");
        return userRepo.save(userFromDb);
    }

    @DeleteMapping
    public void delete(@PathVariable("id") User user) {
        userRepo.delete(user);
    }
}
