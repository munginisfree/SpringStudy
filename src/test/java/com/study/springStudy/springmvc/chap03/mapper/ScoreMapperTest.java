package com.study.springStudy.springmvc.chap03.mapper;

import com.study.springStudy.springmvc.chap03.dto.RankDto;
import com.study.springStudy.springmvc.chap03.dto.ScoreDetailResponseDto;
import com.study.springStudy.springmvc.chap03.entity.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ScoreMapperTest {
    @Autowired
    ScoreMapper scoreMapper;

    @Test
    @DisplayName("전체 조회")
    void findAllTest() {
        //given
        //when
        List<Score> all = scoreMapper.findAll(null);
        //then
        assertEquals(6, all.size());
    }

    @Test
    @DisplayName("개별 조회")
    void findOneTest() {
        //given

        //when
        Score one = scoreMapper.findOne(2);
        //then
        assertEquals("주연", one.getStuName());
    }
    
    @Test
    @DisplayName("순위 조회")
    void findRankTest() {
        //given
        
        //when
        RankDto rankByStuNum = scoreMapper.findRankByStuNum(2);
        //then
        System.out.println(rankByStuNum);
        System.out.println(rankByStuNum.getRank() +" / " + rankByStuNum.getCount());
    }
}