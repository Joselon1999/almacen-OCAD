package com.almacen.ocad.Entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class User {/**/
    @Id
    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;
    @Size(min = 4)
    private String password;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt")
    @CreationTimestamp
    private Date createdAt;

    //Permisos
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",joinColumns = {
            @JoinColumn(name = "USER_EMAIL", referencedColumnName = "email")    //The reference must be the Id field
    }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_NAME", referencedColumnName = "name")      //The reference must be the Id field
    })
    private List<Role> roles;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> recipes;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Order> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Order> recipes) {
        this.recipes = recipes;
    }

    public User() {
    }
}
