package com.almacen.ocad.Repository;

import com.almacen.ocad.Entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,String> {
    //Page<Item> findAllPageable(Pageable pageable);
}
