package com.itarhitekture.restaurantmanagementservice.dao;

import com.itarhitekture.restaurantmanagementservice.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantDAO extends MongoRepository<Restaurant, String> {
}