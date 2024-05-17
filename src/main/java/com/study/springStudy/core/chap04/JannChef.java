package com.study.springStudy.core.chap04;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

@Component
public class JannChef implements Chef {
    @Override
    public void cook(){
        System.out.println("프랑스 요리의 대가 쟝입니다");
    }
}
