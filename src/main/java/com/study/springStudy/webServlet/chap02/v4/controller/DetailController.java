package com.study.springStudy.webServlet.chap02.v4.controller;

import com.study.springStudy.webServlet.MemberMemoryRepo;
import com.study.springStudy.webServlet.OurModel;
import com.study.springStudy.webServlet.entity.Member;

import java.util.Map;

public class DetailController implements ControllerV4{
    private MemberMemoryRepo repo = MemberMemoryRepo.getInstance();
    @Override
    public String process(Map<String, String> paramMap, OurModel model) {
        // 1. 상세조회할 멤버의 account를 읽음
        String account = paramMap.get("account");
        // 2. 저장소에서 상세조회할 멤버의 객체를 가져옴
        Member member = repo.findOne(account);
        // 3. 상세조회할 페이지 (JSP)에게 멤버정보를 보내줌
        model.addAttribute("mem", member);
        // 4. 상세 조회 페이지로 이동
        return "v4/detail";
    }
}
