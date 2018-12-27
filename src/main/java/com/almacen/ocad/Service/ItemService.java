package com.almacen.ocad.Service;

import com.almacen.ocad.Entity.Item;
import com.almacen.ocad.Entity.User;
import com.almacen.ocad.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    //public Page<Item> findAllPageable(Pageable pageable){return itemRepository.findAllPageable(pageable);}

    public List<Item> findAll(){return itemRepository.findAll();}
    public Item save(Item item){return itemRepository.save(item);}
    public void delete(String id){itemRepository.deleteById(id);}
    public Optional<Item> findItemById(String id){return itemRepository.findById(id);}

    public boolean isItemPresent(String id) {
        return itemRepository.existsById(id);
    }
}
