package com.itarhitekture.restaurantmanagementservice.dto;

public class RestaurantDTO {
    private String id;
    private String name;
    private String address;
    private String delovniCas;

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
}