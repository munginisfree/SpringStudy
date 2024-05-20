package com.study.springStudy.springmvc.chap04.dto;

import com.study.springStudy.springmvc.chap04.entity.Board;
import lombok.*;

@Getter @Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
// dto의 필드명은 반드시 html form 태그의 입력태그들 name 속성과 일치해야함
public class BoardWriteRequestDto {

    private String writer;
    private String content;
    private String title;

    public Board toEntity(){
        Board b = new Board();
        b.setWriter(this.writer);
        b.setContent(this.content);
        b.setTitle(this.title);
        return b;
    }

}
