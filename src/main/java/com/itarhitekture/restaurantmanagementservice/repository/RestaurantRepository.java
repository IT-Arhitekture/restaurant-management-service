package com.itarhitekture.restaurantmanagementservice.repository;

import com.itarhitekture.restaurantmanagementservice.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RestaurantRepository extends MongoRepository<Restaurant, String>{

}
