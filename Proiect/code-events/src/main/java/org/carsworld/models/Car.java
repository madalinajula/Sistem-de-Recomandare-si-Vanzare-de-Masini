package org.carsworld.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Car {
    @Id
    @GeneratedValue
    private int id;

    private static int nextId=1;
    private String company;
    private String model;
    private String color;
    private long rolledKilometers;
    private int year;
    private String fuel;
    private String gearbox;
    private int price;
    private double grade;

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public Car(String company, String model,String color,long rolledKiometers,int year,int price,String gearbox,String fuel,double grade){

        this.company=company;
        this.model=model;
        this.color=color;
        this.rolledKilometers=rolledKilometers;
        this.year=year;
        this.price=price;
        this.fuel=fuel;
        this.gearbox=gearbox;
        this.grade=grade;
     }

    public Car(){}
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model= model;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getRolledKilometers() {
        return rolledKilometers;
    }

    public void setRolledKilometers(long rolledKilometers) {
        this.rolledKilometers = rolledKilometers;
    }

    @Override //2 cars with same id but different names and descriptions are not considered the same objects
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
