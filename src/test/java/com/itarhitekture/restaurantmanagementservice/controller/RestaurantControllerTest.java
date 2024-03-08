package com.itarhitekture.restaurantmanagementservice.controller;

import com.itarhitekture.restaurantmanagementservice.dto.RestaurantDTO;
import com.itarhitekture.restaurantmanagementservice.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

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

    @Test
    public void getAllRestaurantsTest() throws Exception {
    RestaurantDTO restaurant = new RestaurantDTO();

    when(restaurantService.getAllRestaurants()).thenReturn(Collections.singletonList(restaurant));

    mockMvc.perform(get("/restaurants")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }


}