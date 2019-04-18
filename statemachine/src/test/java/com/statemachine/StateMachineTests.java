package com.statemachine;

import com.statemachine.model.BookEvents;
import com.statemachine.model.BookStates;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;

public class StateMachineTests extends BookApplicationTests {


    @Autowired
    private StateMachine<BookStates, BookEvents> stateMachine;


    @Test
    public void machineTests(){
        System.out.println("Iniciando máquina de estados...");
        stateMachine.sendEvent(BookEvents.HOTEL_CONFIRMED);
        stateMachine.sendEvent(BookEvents.AIRLINE_CONFIRMED);
        System.out.println("Máquina de estados finalizada");
    }
}
