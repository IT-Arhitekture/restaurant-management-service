package com.itarhitekture.restaurantmanagementservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurants")
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String address;
    private String delovniCas;

    public Restaurant(String name, String address, String delovniCas) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.delovniCas = delovniCas;
    }

    public Restaurant() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDelovniCas() {
        return delovniCas;
    }

    public void setDelovniCas(String delovniCas) {
        this.delovniCas = delovniCas;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", delovniCas='" + delovniCas + '\'' +
                '}';
    }

}
