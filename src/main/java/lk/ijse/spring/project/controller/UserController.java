package lk.ijse.spring.project.controller;

import lk.ijse.spring.project.dto.UserDTO;
import lk.ijse.spring.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value="api/v1/login", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean canAuthenticate(@RequestBody UserDTO user){
        return userService.canAuthenticate(user.getUserName(), user.getPassword());
    }

}
