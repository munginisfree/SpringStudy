package com.study.springStudy.webServlet.chap02.v3.controller;

import com.study.springStudy.webServlet.MemberMemoryRepo;
import com.study.springStudy.webServlet.ModelAndView;
import com.study.springStudy.webServlet.View;
import com.study.springStudy.webServlet.entity.Member;

import java.util.Map;

public class SaveController implements ControllerV3{
    private MemberMemoryRepo repo = MemberMemoryRepo.getInstance();
    @Override
    public ModelAndView process(Map<String, String> paramMap) {
        String userName = paramMap.get("userName");
        String account = paramMap.get("account");
        String password = paramMap.get("password");

        // 2. 회원 정보를 객체를 포장하여 적절한 저장소에 저장
        Member member = new Member(account, password, userName);
//        System.out.println("member = " + member);
        repo.save(member);
        // 3. 적절한 페이지로 이동 - 조회화면으로 리다이렉트
//        response.sendRedirect("/chap02/v1/show");

        return new ModelAndView("redirect:/chap02/v3/show");
    }
}
