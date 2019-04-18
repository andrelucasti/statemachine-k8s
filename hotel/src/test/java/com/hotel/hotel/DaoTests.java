package com.hotel.hotel;

import com.hotel.model.Hotel;
import com.hotel.repository.HotelRepository;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

public class DaoTests extends HotelApplicationTests {


    @Autowired
    private HotelRepository hotelRepository;

    @Rollback(false)
    @Test
    public void saveHotelTest(){
        Hotel hotel = Mockito.mock(Hotel.class);

        Mono<Hotel> monoHotel = hotelRepository.save(hotel);

        assertThat(monoHotel).isNotNull();

    }
}
