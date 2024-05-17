package com.study.springStudy.springmvc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void sTest() {
        Student student = new Student();
        student.setName("ken");
        student.setAge(20);
        student.setGrade(5);

        System.out.println("student = " + student);

        int age = student.getAge();
        System.out.println("age = " + age);
    }

}