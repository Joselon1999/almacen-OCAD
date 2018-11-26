package com.almacen.ocad.Service;

import com.almacen.ocad.Entity.ItemList;
import com.almacen.ocad.Entity.Order;
import com.almacen.ocad.Repository.ItemListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemListService {

    @Autowired
    private ItemListRepository itemListRepository;

    public List<ItemList> findByOrderId(String id){return itemListRepository.findByOrder_Id(id);}
}
