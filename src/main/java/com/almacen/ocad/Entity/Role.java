package com.almacen.ocad.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Role {

    @Id
    @NotEmpty
    @Column(unique = true)
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role() {
    }

    //Asignador para tipos de Roles
    public Role(@NotEmpty String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
