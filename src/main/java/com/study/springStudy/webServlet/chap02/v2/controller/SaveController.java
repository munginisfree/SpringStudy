package com.study.springStudy.webServlet.chap02.v2.controller;

import com.study.springStudy.webServlet.MemberMemoryRepo;
import com.study.springStudy.webServlet.View;
import com.study.springStudy.webServlet.entity.Member;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveController implements ControllerV2 {
    private MemberMemoryRepo repo = MemberMemoryRepo.getInstance();

    @Override
    public View process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        // 2. 회원 정보를 객체를 포장하여 적절한 저장소에 저장
        Member member = new Member(account, password, userName);
//        System.out.println("member = " + member);
        repo.save(member);
        // 3. 적절한 페이지로 이동 - 조회화면으로 리다이렉트
//        response.sendRedirect("/chap02/v1/show");

        return new View("redirect:/chap02/v2/show");
    }
}
