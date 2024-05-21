package com.study.springStudy.database.chap02;

import com.study.springStudy.database.chap01.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonMapperTest {
    @Autowired
    PersonMapper mapper;

    @Test
    @DisplayName("마이바티스 매퍼로 사람 정보를 등록한다.")
    void saveTest() {
        //given
        Person p = new Person(9999, "초록이", 60);
        //when
        boolean flag = mapper.save(p);

        //then
        assertTrue(flag);
    }

    @Test
    @DisplayName("아이디로 사람 정보 삭제한다")
    void delTest() {
        //given
        long id = 9999;
        //when
        boolean flag = mapper.delete(id);
        //then
        assertTrue(flag);
    }

    @Test
    @DisplayName("아이디가 1인 사람의 정보를 수정한다")
    void updateTest() {
        //given
        Person p = new Person(1, "barbie", 45);
        //when
        boolean flag = mapper.update(p);
        //then
        assertTrue(flag);
    }

    @Test
    @DisplayName("전체 조회하면 결과 건수 3건")
    void findAllTest() {
        //given

        //when
        List<Person> all = mapper.findAll();
        for (Person person : all) {
            System.out.println("person = " + person);
        };
        //then
        assertTrue(all.size() == 3);
    }
    
    @Test
    @DisplayName("id로 사람 정보를 개별조회한다")
    void findOneTest() {
        //given
        long id = 1;
        //when
        Person one = mapper.findOne(id);
        //then
        assertEquals("barbie", one.getPersonName());
    }

    @Test
    @DisplayName("사람 수와 이름리스트를 조회한다")
    void findByNameTest() {
        //given

        //when
        List<String> names = mapper.findNames();
        System.out.println("names = " + names);
        //then
        assertTrue(names.size() == 3);
    }
}