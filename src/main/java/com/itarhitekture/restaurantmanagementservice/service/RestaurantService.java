package com.itarhitekture.restaurantmanagementservice.service;

import com.itarhitekture.restaurantmanagementservice.dao.RestaurantDAO;
import com.itarhitekture.restaurantmanagementservice.dto.RestaurantDTO;
import com.itarhitekture.restaurantmanagementservice.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantDAO restaurantDAO;

    public List<RestaurantDTO> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantDAO.findAll();
        return restaurants.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public RestaurantDTO getRestaurantById(String id) {
        Optional<Restaurant> restaurant = restaurantDAO.findById(id);
        return restaurant.map(this::convertToDTO).orElse(null);
    }

    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant(
            restaurantDTO.getName(),
            restaurantDTO.getAddress(),
            restaurantDTO.getDelovniCas()
        );
        return convertToDTO(restaurantDAO.save(restaurant));
    }



    public void deleteRestaurant(String id) {
        restaurantDAO.deleteById(id);
    }

    private RestaurantDTO convertToDTO(Restaurant restaurant) {
        RestaurantDTO dto = new RestaurantDTO();
        dto.setId(restaurant.getId());
        dto.setName(restaurant.getName());
        dto.setAddress(restaurant.getAddress());
        dto.setDelovniCas(restaurant.getDelovniCas());
        return dto;
    }
}