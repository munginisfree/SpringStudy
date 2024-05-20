package com.study.springStudy.springmvc.chap03.repository;

import com.study.springStudy.springmvc.chap03.entity.Score;

import java.util.*;

//역할: 적당한 저장소에 CRUD하기
public interface ScoreRepository {

    // 저장소에 데이터 추가하기
    boolean save(Score score);
    // 저장소에서 데이터 전체조회하기
    List<Score> findAll(String sort);
    // 저장소에서 데이터 개별조회하기
    Score findOne(long stuNum);

    default boolean delete(long stuNum){
        return false;
    }; // 강제 overriding에서 빠짐
    // 저장소에서 데이터 삭제하기

    // 저장소에서 등수, 전체인원 조회하기
    int[] findRankByStuNum(long stuNum);
}
