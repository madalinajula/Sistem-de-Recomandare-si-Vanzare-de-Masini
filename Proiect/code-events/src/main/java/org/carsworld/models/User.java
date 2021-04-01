package org.carsworld.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue
    public int id;


    public String username;
    private String password;
    private String name;
    private String phone;
    private String city;


    public User(String username,String password,String name,String phone,String city){

        this.username=username;
        this.password=password;
        this.name=name;
        this.phone=phone;
        this.city=city;
    }

    public User(){}
    public int getIdUser() {
        return id;
    }
    public void setIdUser(int idUser) {
        this.id = idUser;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Override //2 cars with same id but different names and descriptions are not considered the same objects
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
