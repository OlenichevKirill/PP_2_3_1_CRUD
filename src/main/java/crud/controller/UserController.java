package crud.controller;

import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all-users";
    }

    @GetMapping("/newUser")
    public String addNewUser(@ModelAttribute("user") User user) {
        return "new-user";
    }

    @PostMapping("/new")
    public String saveNewUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new-user";
        }
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String getUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit-user";
    }

    @PatchMapping("/updateUser/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                             @PathVariable("id") long id) {
        if (bindingResult.hasErrors()) {
            return "edit-user";
        }
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.removeUserById(id);
        return "redirect:/";
    }
}
