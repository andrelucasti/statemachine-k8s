package com.statemachine.services;

import com.statemachine.model.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HotelServiceLocalHost implements HotelService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Boolean createReserve(Reserve reserve) {

        ResponseEntity<Reserve> responseEntity =  restTemplate.postForEntity("localhost:8282/reserve", reserve, Reserve.class);

        return responseEntity.getStatusCode() == HttpStatus.CREATED;
    }
}
