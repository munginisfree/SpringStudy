package com.study.springStudy.springmvc.chap04.service;

import com.study.springStudy.springmvc.chap04.entity.Board;
import com.study.springStudy.springmvc.chap04.mapper.BoardMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BoardServiceTest {
    @Autowired
    BoardMapper mapper;

    @Test
    @DisplayName("전체 조회")
    void findAll() {
        //given

        //when
        List<Board> bList = mapper.findAll();
        //then
        System.out.println("bList = " + bList);
        assertEquals(2, bList.size());
    }
    
    @Test
    @DisplayName("개별 조회")
    void findOneTest() {
        //given
        int boardId = 23;
        //when
        Board one = mapper.findOne(23);
        System.out.println("one = " + one);
        //then
        assertEquals("정인", one.getWriter());
    }

    @Test
    @DisplayName("추가")
    void saveTest() {
        //given
        Board board = new Board();
        board.setTitle("saveTest");
        board.setContent("Content");
        board.setWriter("Writer");
        //when
        boolean save = mapper.save(board);
        //then
        System.out.println("save = " + save);
    }

    @Test
    @DisplayName("제거")
    void delTest() {
        //given
        int boardId = 26;
        //when
        boolean delete = mapper.delete(26);
        //then
        System.out.println("delete = " + delete);
    }

    @Test
    @DisplayName("업데이트")
    void updateTest() {
        //given
        int boardId = 26;
        //when
        mapper.upViewCount(25);
        Board one = mapper.findOne(25);
        //then
        System.out.println(one.getViewCount());
    }
}