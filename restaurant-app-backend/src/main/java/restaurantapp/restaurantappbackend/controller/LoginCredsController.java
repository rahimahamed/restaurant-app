package restaurantapp.restaurantappbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantapp.restaurantappbackend.model.LoginCreds;
import restaurantapp.restaurantappbackend.service.LoginCredsService;

@RestController
@RequestMapping("/loginCreds")
public class LoginCredsController {
    private final LoginCredsService loginCredsService;

    public LoginCredsController(LoginCredsService loginCredsService) { this.loginCredsService = loginCredsService; }

    @GetMapping("/find/{username}")
    public ResponseEntity<LoginCreds> getLoginCredsByUsernameAndPassword(@PathVariable("username") String username, String password) {
        LoginCreds loginCreds = loginCredsService.findLoginCredsByUsernameAndPassword(username, password);
        return new ResponseEntity<>(loginCreds, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<LoginCreds> addLoginCreds(@RequestBody LoginCreds loginCreds){
        LoginCreds newLoginCreds = loginCredsService.addLoginCreds(loginCreds);
        return new ResponseEntity<>(newLoginCreds, HttpStatus.CREATED);
    }
}
