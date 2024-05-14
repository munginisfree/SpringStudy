package com.study.springStudy.chap03;

import com.study.springStudy.core.chap03.Hotel;
import com.study.springStudy.core.chap03.config.HotelManager;
import org.junit.jupiter.api.Test;

class HotelDiTest {
    @Test
    void diTest(){
        HotelManager hotelManager = new HotelManager();
        Hotel hotel = hotelManager.hotel();
        hotel.inform();
    }
}