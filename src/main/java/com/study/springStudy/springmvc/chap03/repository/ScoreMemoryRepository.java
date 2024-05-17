package com.study.springStudy.springmvc.chap03.repository;

import com.study.springStudy.springmvc.chap03.entity.Score;

import java.util.List;

public class ScoreMemoryRepository implements ScoreRepository {

    @Override
    public boolean save(Score score) {
        return false;
    }

    @Override
    public List<Score> findAll() {
        return List.of();
    }

    @Override
    public Score findOne(long stuNum) {
        return null;
    }

    @Override
    public boolean remove(long stuNum) {
        return false;
    }
}
