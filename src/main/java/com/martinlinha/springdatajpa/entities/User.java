package com.martinlinha.springdatajpa.entities;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private String phoneNumber;
    @CreatedDate
    private Date createdOn;
    @Embedded
    private Address homeAddress;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "city", column = @Column(name = "work_city")),
            @AttributeOverride(name = "country", column = @Column(name = "work_country")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "work_zip_code")),
            @AttributeOverride(name = "street", column = @Column(name = "work_street"))
    })
    private Address workAddress;

    public User() {
    }

    public User(String name, Integer age, String email, String phoneNumber, Address homeAddress, Address workAddress) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getHomeAddress() {
        if (homeAddress == null) {
            homeAddress = new Address();
        }
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getWorkAddress() {
        if (workAddress == null) {
            workAddress = new Address();
        }
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", createdOn=" + createdOn +
                ", homeAddress=" + homeAddress +
                ", workAddress=" + workAddress +
                '}';
    }
}
