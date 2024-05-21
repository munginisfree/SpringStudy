package com.study.springStudy.database.chap01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class SpringJdbcTest {
    @Autowired
    SpringJdbc springJdbc;

    // 각 테스트 전에 공통으로 실행할 코드
    @BeforeEach
    void bulkInsert(){
        for (int i = 0; i < 10; i++) {
            Person p = new Person(i + 2000, "testmen" + i, 10);
            springJdbc.save(p);
        }
    }

    // 단위 테스트 프레임워크 : JUnit5
    // 테스트는 == 단언 (Assertion)
    @Test
    @DisplayName("사람의 정보를 입력하면 데이터베이스에 반드시 저장되어야한다.")
    void saveTest() {
        // gwt pattern
        // given : 테스트에 주어질 데이터
        Person person = new Person(1000, "k", 1000);
        // when : 테스트 상황
        int result = springJdbc.save(person);
        // then : 테스트 결과 단언
        assertEquals(1, result);
    }

    @Test
    @DisplayName("아이디가 주어지면 해당 아이디의 사람정보가 데이터베이스로부터 삭제되어야한다.")
    void deleteTest() {
        //given
        long id = 77;
        //when
        boolean result = springJdbc.delete(id);
        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("사람이 주어지면 해당 사람정보의 이름과 나이를 수정합니다")
    void updateTest() {
        //given
        Person newPerson = new Person(79, "chillchill", 7);
        //when
        boolean update = springJdbc.update(newPerson);
        //then
        assertTrue(update);
    }

    @Test
    @DisplayName("사람 정보를 전체조회하면 결과건수는 3건이며, 첫번째 사람의 이름은 theFirst이다.")
    void findAllTest() {
        //given

        //when
        List<Person> ppl = springJdbc.findAll();
        //then
        for (Person person : ppl) {
            System.out.println("person = " + person);
        }
        assertEquals(3, ppl.size());
        assertEquals("theFirst", ppl.get(0).getPersonName());
    }

    @Test
    @DisplayName("사람 정보를 아이디로 단일 조회시 아이디가 101인 사람의 이름은 oneOone이다." +
            " 나이는 7세이다.")
    void findOneTest() {
        //given
        long id = 101;
        //when
        Person one = springJdbc.findOne(id);
        //then
        System.out.println("one = " + one);
        assertNotNull(one);
        assertEquals("oneOone", one.getPersonName());
        assertEquals(7, one.getPersonAge());
    }
}