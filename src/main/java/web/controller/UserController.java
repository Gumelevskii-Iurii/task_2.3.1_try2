package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String users(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "usersPage";
    }

    @GetMapping("/addUsers")
    public String addNewUsers(Model model) {
        model.addAttribute("user", new User());
        return "addUsers";
    }

    @PostMapping("/addUsers")
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("deleteUsers/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/changeUsers/{id}")
    public String changeUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "/changeUsers";
    }

    @PostMapping("/changeUsers")
    public String changeUser(User user) {
        userService.changeUser(user);
        return "redirect:/";
    }

}




