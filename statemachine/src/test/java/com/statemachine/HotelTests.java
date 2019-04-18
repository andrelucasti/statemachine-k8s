package com.statemachine;

import com.statemachine.model.Reserve;
import com.statemachine.services.HotelService;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


public class HotelTests extends BookApplicationTests {

    @Mock
    private HotelService hotelService;


    @Test
    public void hotelServiceTest(){
        Reserve reserve = Mockito.mock(Reserve.class);

        Mockito.when(hotelService.createReserve(reserve)).thenReturn(true, false);

        hotelService.createReserve(reserve);

        Mockito.verify(hotelService).createReserve(reserve);



    }


}
