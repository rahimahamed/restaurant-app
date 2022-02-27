package restaurantapp.restaurantappbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurantapp.restaurantappbackend.model.LoginCreds;

import java.util.Optional;

public interface LoginCredsRepository extends JpaRepository<LoginCreds, String> {
    Optional<LoginCreds> findLoginCredsByUsernameAndPassword(String username, String password);
}
