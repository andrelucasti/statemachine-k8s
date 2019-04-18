package com.hotel.repository;

import com.hotel.model.Hotel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface HotelRepository extends ReactiveMongoRepository<Hotel,Long> {
}
