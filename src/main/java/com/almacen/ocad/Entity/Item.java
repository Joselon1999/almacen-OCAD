package com.almacen.ocad.Entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class Item {/**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @NotEmpty
    private String name;
    @NotEmpty
    private String codigo;
    @NotEmpty
    private String description;
    @NotEmpty
    private int quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt")
    @CreationTimestamp
    private Date createdAt;

    @PrePersist
    public void prePersist(){
        createdAt = new Date();
    }

    public Item() {
    }

    public Item(long id, String name, String codigo,int quantity, String description, Date createdAt) {
        this.id = id;
        this.name = name;
        this.codigo = codigo;
        this.description = description;
        this.quantity=quantity;
        this.createdAt = createdAt;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
