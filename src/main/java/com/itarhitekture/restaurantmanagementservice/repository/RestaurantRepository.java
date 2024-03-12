package com.itarhitekture.restaurantmanagementservice.repository;

import com.itarhitekture.restaurantmanagementservice.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String>{

}
