package com.example.oms.controller;

import com.example.oms.demo.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CRUDTest {

    @Mock
    DiscountService discountService;

    @InjectMocks
    PriceService priceService;

    @Mock
    EmailService emailService;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    NotificationService notificationService;

    @Test
    void testNortmalFlowNotify(){
        when(userRepository.findById(1)).thenReturn(new User(1,"zalupa@asd"));
        notificationService.notifyUser(1);
        verify(emailService, times(1)).sendEmail("zalupa@asd");
    }

    @Test
    void test404FlowNotify(){
//        when(userRepository.findById(1)).thenReturn(new User(1,"zalupa@asd"));
        assertThrows(IllegalArgumentException.class, () ->notificationService.notifyUser(1));
    }


    @Test
    void testPriceWithDiscount(){
        when(discountService.getDiscount()).thenReturn(10);
        int price = priceService.calculatePrice(100);
        System.out.println(price);
        price = priceService.calculatePrice(100);
        System.out.println(price);
        price = priceService.calculatePrice(100);
        System.out.println(price);

    }

    @Test
    void testExceptionHandling(){
        assertThrows(IllegalArgumentException.class, () -> priceService.calculatePrice(-100));
    }

}
