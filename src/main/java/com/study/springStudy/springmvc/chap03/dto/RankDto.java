package com.study.springStudy.springmvc.chap03.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor
public class RankDto {
    private int rank;
    private int count;
}
