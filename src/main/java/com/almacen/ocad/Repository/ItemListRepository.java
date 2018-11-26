package com.almacen.ocad.Repository;

import com.almacen.ocad.Entity.ItemList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemListRepository extends JpaRepository<ItemListRepository, String> {
    List<ItemList> findByOrder_Id(String id);
}
