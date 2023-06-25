package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "serviceProviders")
@Entity
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn
    private Admin admin;


    @OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL)
    private List<Country> countryList = new ArrayList<>();

    @ManyToMany(mappedBy = "serviceProviderList", cascade = CascadeType.ALL)
    private List<User> userList = new ArrayList<>();

    @OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL)
    private List<Connection> connectionList = new ArrayList<>();


//    // //////////////////////////////////
//    @Data


    public ServiceProvider() {
    }

    public ServiceProvider(int id, String name, Admin admin, List<Country> countryList, List<User> userList, List<Connection> connectionList) {
        this.id = id;
        this.name = name;
        this.admin = admin;
        this.countryList = countryList;
        this.userList = userList;
        this.connectionList = connectionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }
}
