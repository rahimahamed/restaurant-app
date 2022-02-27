package restaurantapp.restaurantappbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurantapp.restaurantappbackend.model.Item;

public interface ItemRepository extends JpaRepository<Item, String> {
}
