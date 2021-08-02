package com.example.products.Controller;

import com.example.products.Dao.User;
import com.example.products.Service.UserServiceImpl;
import org.apache.ibatis.jdbc.Null;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class Usercontroller {

    @Autowired
    private UserServiceImpl userService;
    //用户注册 username 和password
    @PostMapping("/signup")
    public Map<String, Object> addUser(@RequestBody User user){

        int stat = userService.insertUser(user);
        Map<String, Object> map = new HashMap<>(3);
        if (stat == 1){
            map.put("msg", "ok");
            map.put("code", "200");
            return map;
        }else {
            map.put("msg", "error");
            map.put("code", "101");
            return map;
        }
    }
    //用户登录 username 和password
    @PostMapping("/login")
    public User ValidateUser(@RequestBody User user){
        User stat = userService.validate(user);
        return stat;
    }
}
