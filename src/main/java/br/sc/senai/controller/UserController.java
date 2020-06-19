package br.sc.senai.controller;

import br.sc.senai.model.User;
import br.sc.senai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestParam String name
            , @RequestParam String email, @RequestParam String password) {
        User u = new User();
        u.setName(name);
        u.setEmail(email);
        u.setPassword(password);
        userRepository.save(u);
        return "User inserted into the DB";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping(path = "/update")
    public @ResponseBody
    String updateUser(@RequestParam Integer id, @RequestParam String name
            , @RequestParam String email, @RequestParam String password) {
        User u = userRepository.findById(id).get();
        u.setName(name);
        u.setEmail(email);
        u.setPassword(password);
        userRepository.save(u);
        return "User "+u.getId()+" updated in the DB";
    }

    @PostMapping(path = "/remove")
    public @ResponseBody
    String removeUser(@RequestParam Integer id) {
        userRepository.deleteById(id);
        return "User removed from the DB";
    }

    @PostMapping(path = "/allbyname")
    public @ResponseBody
    Iterable<User> findByName(@RequestParam String name) {
        return userRepository.findAllByName(name);
    }
}
