package com.itarhitekture.restaurantmanagementservice.controller;

import com.itarhitekture.restaurantmanagementservice.dto.RestaurantDTO;
import com.itarhitekture.restaurantmanagementservice.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/restaurants")
@Tag(name = "Restaurants controller", description = "API for restaurants operations")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantController.class);


    @Autowired
    public RestaurantController (RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    @Operation(summary = "Get all restaurants", description = "Returns list of all restaurants")
    public List<RestaurantDTO> getAllRestaurants(){
        LOGGER.info("[GET] - /restaurants");
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable String id){
        RestaurantDTO restaurantDTO = restaurantService.getRestaurantById(id);
        if (restaurantDTO != null) {
            LOGGER.info("[GET] - /restaurants/", id);
            return ResponseEntity.ok(restaurantDTO);
        } else {
            LOGGER.warn("[GET] - /restaurants/", id,": No restaurant found !");
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Add a new restaurant", description = "Returns the added restaurant")
    public RestaurantDTO addRestaurant(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Restaurant to be added", required = true, content = @Content(schema = @Schema(implementation = RestaurantDTO.class), examples = @ExampleObject(value = "{\"name\": \"Test Restaurant\", \"address\": \"Test Address\", \"delovniCas\": \"11:00-23:00\"}")))
            @RequestBody RestaurantDTO restaurantDTO){
        LOGGER.info("[POST] - /restaurants, Restaurant name: {}", restaurantDTO.getName());
        return restaurantService.addRestaurant(restaurantDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable String id){
        LOGGER.info("[DELETE] - /restaurants/{}", id);
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }
}