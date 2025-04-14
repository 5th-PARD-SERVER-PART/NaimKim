package com.pard5.seminar4.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserRes getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("")
    public void createUser(@RequestBody UserReq request) {
        userService.createUser(request);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
