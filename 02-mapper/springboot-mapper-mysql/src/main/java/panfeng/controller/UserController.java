package panfeng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import panfeng.entity.User;
import panfeng.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController
{
    @Autowired
    private UserService userService;


    // http://localhost:1801/user/register
    // body > raw > json
    // {"u_username":"administrator","u_password":"123456","u_phone":"18574150851"}
    //public ResponseEntity<Void> register(@RequestBody(required = false) User user)


    // http://localhost:1801/user/register?u_username=administrator&u_password=123456&u_phone=18574150851

    /**
     * http://localhost:1801/user/register
     * Body > form-data 中写
     * u_username administrator
     * u_password 123456
     * u_phone 18574150851
     */

    @PostMapping("register")
    public ResponseEntity<Void> register(@Valid User user)
    {
        Boolean bool = userService.register(user);
        if (bool == null || !bool)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // localhost:1801/user/query?username=administrator&password=123456

    @GetMapping("query")
    public ResponseEntity<User> queryUser(@RequestParam("username") String username, @RequestParam("password") String password)
    {
        User user = this.userService.queryUser(username, password);
        if (user == null)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(user);
    }
}