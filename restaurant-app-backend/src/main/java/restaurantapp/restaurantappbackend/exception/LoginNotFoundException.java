package restaurantapp.restaurantappbackend.exception;

public class LoginNotFoundException extends RuntimeException{
    public LoginNotFoundException(String message) { super(message); }
}
