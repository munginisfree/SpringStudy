package com.study.springStudy.database.chap01;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Setter @Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private long id;
    private String person_name;
    private int person_age;

    public Person(ResultSet rs) throws SQLException {
        this.id = rs.getLong("id");
        this.person_name = rs.getString("person_name");
        this.person_age = rs.getInt("person_age");
    }
}
