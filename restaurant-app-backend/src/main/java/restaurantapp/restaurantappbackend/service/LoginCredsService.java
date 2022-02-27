package restaurantapp.restaurantappbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurantapp.restaurantappbackend.exception.LoginNotFoundException;
import restaurantapp.restaurantappbackend.model.Item;
import restaurantapp.restaurantappbackend.model.LoginCreds;
import restaurantapp.restaurantappbackend.repository.LoginCredsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginCredsService {
    private final LoginCredsRepository loginCredsRepository;

    @Autowired
    public LoginCredsService(LoginCredsRepository loginCredsRepository) { this.loginCredsRepository = loginCredsRepository; }

    public LoginCreds addLoginCreds(LoginCreds loginCreds){
        ArrayList<Item> items = new ArrayList<Item>();
        loginCreds.setCart(items);
        return loginCredsRepository.save(loginCreds);
    }

    public LoginCreds findLoginCredsByUsernameAndPassword(String username, String password){
        return loginCredsRepository.findLoginCredsByUsernameAndPassword(username,password).orElseThrow(() -> new LoginNotFoundException("Login by username " + username + " was not found"));
    }

    public LoginCreds addToCart(LoginCreds loginCreds, Item item){
        List<Item> items = loginCreds.getCart();
        items.add(item);
        loginCreds.setCart(items);
        return loginCredsRepository.save(loginCreds);
    }
}
