package com.statemachine.clients;

import com.statemachine.model.Reserve;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("hotel-service")
public interface HotelClient {
    @PostMapping("/reserve")
    @ResponseBody
    Boolean createReserve(@RequestBody  Reserve reserve);
}
