package com.almacen.ocad.Service;

import com.almacen.ocad.Entity.Order;
import com.almacen.ocad.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){return orderRepository.findAll();}
    public Order save(Order order){return orderRepository.save(order);}
    public void delete(String id){orderRepository.deleteById(id);}
    public Optional<Order> findById(String id){return orderRepository.findById(id);}

    public boolean isOrderPresent(String id){return orderRepository.existsById(id);}
}
