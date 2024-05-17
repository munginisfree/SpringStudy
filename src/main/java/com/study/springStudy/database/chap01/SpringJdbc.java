package com.study.springStudy.database.chap01;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
@Component
@RequiredArgsConstructor
public class SpringJdbc {
    private final JdbcTemplate template;

    //INSERT
    public int save(Person person){
        String sql = "insert into tbl_person values (?, ?, ?)";

        return template.update(sql, person.getId(),
                person.getPerson_name(), person.getPerson_age());
    }

    // DELETE
    public boolean delete(long id){
        String sql = "delete from tbl_person where id = ?";
        int result = template.update(sql, id);
        return result == 1;
    }

    // UPDATE
    public boolean update(Person newPerson){
        // 이름과 나이 수정
        String sql = "UPDATE tbl_person SET person_name = ?, person_age = ? WHERE id = ?";
        int result = template.update(sql,  newPerson.getPerson_name(), newPerson.getPerson_age(), newPerson.getId());
        return result == 1;
    }

    //SELECT: 다중행조회
    public List<Person> findAll(){
        String sql = "select * from tbl_person";
        return template.query(sql, (rs, rowNum) -> new Person(rs));
    }

    //SELECT : 단일행 조회
    public Person findOne(long id){
        String sql = "select * from tbl_person where id = ?";
        return template.queryForObject(sql, (rs, n) -> new Person(rs), id);
    }

    // 내부 클래스
//    public static class PersonMapper implements RowMapper<Person>{
//        @Override
//        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
//            Person p = new Person();
////            p.setId(rs.getLong("id"));
////            p.setPerson_name(rs.getString("person_name"));
////            p.setPerson_age(rs.getInt("person_age"));
//            return p;
//        }
//    }

}
