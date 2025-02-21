package Altakus.FinTrack.controller;

import Altakus.FinTrack.model.User;
import Altakus.FinTrack.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    // Метод регистрации пользователя
    @CrossOrigin(origins = "http://localhost")
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User createdUser = userService.registerUser(user); // Создаем временного пользователя для проверки уникальности Адреса
        if(createdUser != null){
            return ResponseEntity.ok(createdUser); // Отправляем 200 с созданным пользователем
        }
        else{
            return ResponseEntity.badRequest().build(); // Отправляем 400, если такой пользователь уже есть
        }
    }
}
