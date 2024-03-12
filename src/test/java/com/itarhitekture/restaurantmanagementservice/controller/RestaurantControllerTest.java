package com.itarhitekture.restaurantmanagementservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itarhitekture.restaurantmanagementservice.dto.RestaurantDTO;
import com.itarhitekture.restaurantmanagementservice.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestaurantService restaurantService;
    private RestaurantDTO restaurant;

    @BeforeEach
    public void setup() {
        restaurant = new RestaurantDTO();
        restaurant.setName("Test Restaurant");
        restaurant.setAddress("Ulica na Cesto 12");
        restaurant.setDelovniCas("11:00-23:00");
    }
    @Test
    public void getAllRestaurantsTest() throws Exception {
        Mockito.when(restaurantService.getAllRestaurants()).thenReturn(Arrays.asList(restaurant));

        mockMvc.perform(MockMvcRequestBuilders.get("/restaurants")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)));
    }

    @Test
    public void getRestaurantByIdTest() throws Exception {
        Mockito.when(restaurantService.getRestaurantById("1")).thenReturn(restaurant);

        mockMvc.perform(MockMvcRequestBuilders.get("/restaurants/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(restaurant.getId())));
    }


    @Test
    public void addRestaurantTest() throws Exception {
        Mockito.when(restaurantService.addRestaurant(ArgumentMatchers.any(RestaurantDTO.class))).thenReturn(restaurant);

        mockMvc.perform(MockMvcRequestBuilders.post("/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(restaurant)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", is(restaurant.getName())));
    }
    @Test
    public void deleteRestaurantTest() throws Exception {
        Mockito.doNothing().when(restaurantService).deleteRestaurant("1");

        mockMvc.perform(MockMvcRequestBuilders.delete("/restaurants/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

}