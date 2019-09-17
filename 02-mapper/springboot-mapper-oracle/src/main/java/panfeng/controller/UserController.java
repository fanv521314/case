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


    // http://localhost:1802/user/register
    // body > raw > json
    // {"u_username":"a169","u_password":"a105","u_phone":"18574150851"}
    //public ResponseEntity<Void> register(@RequestBody(required = false) User user)


    // http://localhost:1802/user/register?u_username=a169&u_password=a105&u_phone=18574150851

    /**
     * http://localhost:1802/user/register
     * Body > form-data 中写
     * u_username a169
     * u_password a105
     * u_phone 18574150851
     */

    @PostMapping("register")
    //public ResponseEntity<Void> register(@Valid User user)
    public ResponseEntity<Void> register(@RequestParam("username") String username,
                                         @RequestParam("password") String password,
                                         @RequestParam("phone") String phone)
    {
        Boolean bool = userService.register(new User(null,username,password,phone,null,null));
        if (bool == null || !bool)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // localhost:1801/user/query?username=administrator&password=123456

    @PostMapping("login")
    public ResponseEntity<User> login(@RequestParam("username") String username,
                                          @RequestParam("password") String password)
    {
        User result = this.userService.login(username, password);
        if (result == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("query")
    public ResponseEntity<User> query(@RequestParam(name = "username",required = false) String username,
                                      @RequestParam(name = "phone",required = false) String phone)
    {
        User result = this.userService.query(new User(null,username,null,phone,null,null));
        if (result == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

}