package com.driver.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String username;

    private String password;
    private String originalIp;

    private String maskedIp;

    private Boolean connected;

    @OneToOne     /////////
    @JoinColumn
    private Country originalCountry;

    @ManyToMany     //////////
    @JoinColumn
    private List<ServiceProvider> serviceProviderList = new ArrayList<>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Connection> connectionList = new ArrayList<>();


//  //////////////////////////////////
//  @Data


    public User() {
    }

    public User(int id, String username, String password, String originalIp, String maskedIp, boolean connected, Country originalCountry, List<ServiceProvider> serviceProviderList, List<Connection> connectionList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.originalIp = originalIp;
        this.maskedIp = maskedIp;
        this.connected = connected;
        this.originalCountry = originalCountry;
        this.serviceProviderList = serviceProviderList;
        this.connectionList = connectionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getOriginalIp() {
        return originalIp;
    }

    public void setOriginalIp(String originalIp) {
        this.originalIp = originalIp;
    }

    public String getMaskedIp() {
        return maskedIp;
    }

    public void setMaskedIp(String maskedIp) {
        this.maskedIp = maskedIp;
    }
//hello hello
    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public Country getOriginalCountry() {
        return originalCountry;
    }

    public void setOriginalCountry(Country originalCountry) {
        this.originalCountry = originalCountry;
    }

    public List<ServiceProvider> getServiceProviderList() {
        return serviceProviderList;
    }

    public void setServiceProviderList(List<ServiceProvider> serviceProviderList) {
        this.serviceProviderList = serviceProviderList;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }
}