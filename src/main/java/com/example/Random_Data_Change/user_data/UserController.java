package com.example.Random_Data_Change.user_data;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/data")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAllUserData(){return userService.getAllUser();}

    @GetMapping("/name")
    public List<String> getName(){return userService.getName();}

    @GetMapping("/rand")
    public List<User> getRandName(){return userService.randUserName();}

    @GetMapping("/{id}")
    public User getUserData(@PathVariable(value = "id")Long id){ return userService.getUserById(id);}

    @PostMapping
    public User createUserData(@Valid @RequestBody User userData){ return userService.createUser(userData); }

    @PutMapping("/{id}")
    public User updateUserData(@PathVariable(value = "id") Long id, @Valid @RequestBody User userData){return userService.updateUser(id,userData);}

    @DeleteMapping("/{id}")
    public void deleteUserData(@PathVariable(value = "id") Long id){ userService.deleteUser(id); }
}
