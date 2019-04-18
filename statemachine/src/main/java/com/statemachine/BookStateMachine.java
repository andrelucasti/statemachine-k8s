package com.statemachine;

import com.statemachine.model.BookEvents;
import com.statemachine.model.BookStates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class BookStateMachine extends EnumStateMachineConfigurerAdapter<BookStates, BookEvents> {

    @Bean
    public StateMachineListener<BookStates, BookEvents> listener(){
        return new StateMachineListenerAdapter<BookStates, BookEvents>(){
            @Override
            public void stateChanged(State<BookStates, BookEvents> from, State<BookStates, BookEvents> to) {

                if(from != null){
                    System.out.println("Book change from " + from.getId() + " to " + to.getId());
                }

            }
        };
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<BookStates, BookEvents> config) throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<BookStates, BookEvents> states) throws Exception {
        states
                .withStates()
                .initial(BookStates.HOTEL_RESERVED)
                .states(EnumSet.allOf(BookStates.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<BookStates, BookEvents> transitions) throws Exception {

        transitions
                .withExternal()

                 // Hotel > Airline
                .source(BookStates.HOTEL_RESERVED).target(BookStates.AIRLINE_RESERVED)
                    .event(BookEvents.HOTEL_CONFIRMED)
                .and()
                .withExternal()

                // Airline > Book Created
                .source(BookStates.AIRLINE_RESERVED).target(BookStates.CREATED)
                    .event(BookEvents.AIRLINE_CONFIRMED);
    }
}
