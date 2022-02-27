package restaurantapp.restaurantappbackend.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "login_creds")
public class LoginCreds implements Serializable{
    @Id
    @Column(nullable = false)
    private String username;
    private String password;
    @OneToMany()
    @JoinColumn(name="login_creds_username")
    private List<Item> cart;

    public LoginCreds(){
    }

    public LoginCreds(String username, String password, List<Item> cart){
        this.username = username;
        this.password = password;
        this.cart = cart;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "LoginCreds{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", cart=" + cart +
                '}';
    }
}
