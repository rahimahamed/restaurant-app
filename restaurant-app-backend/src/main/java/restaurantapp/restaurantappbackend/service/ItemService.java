package restaurantapp.restaurantappbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurantapp.restaurantappbackend.model.Item;
import restaurantapp.restaurantappbackend.repository.ItemRepository;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository){this.itemRepository = itemRepository;}

    public Item addItem(Item item) {return itemRepository.save(item);}

    public List<Item> findAllItems() {return itemRepository.findAll();}
}
