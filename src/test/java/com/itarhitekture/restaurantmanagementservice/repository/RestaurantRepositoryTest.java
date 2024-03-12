package com.itarhitekture.restaurantmanagementservice.repository;

import com.itarhitekture.restaurantmanagementservice.model.Restaurant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class RestaurantRepositoryTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @DisplayName("given object to save"
            + " when save object using MongoDB template"
            + " then object is saved")
    @Test
    public void test() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Test Restaurant");
        restaurant.setAddress("Test Address");
        restaurant.setDelovniCas("10:00 - 22:00");

        mongoTemplate.save(restaurant, "restaurants");

        assertThat(mongoTemplate.findAll(Restaurant.class, "restaurants")).extracting("name")
                .containsOnly("Test Restaurant");
    }
}