package com.study.springStudy.webServlet.chap02.v4.controller;

import com.study.springStudy.webServlet.MemberMemoryRepo;
import com.study.springStudy.webServlet.Model;
import com.study.springStudy.webServlet.ModelAndView;
import com.study.springStudy.webServlet.entity.Member;

import java.util.List;
import java.util.Map;

public class ShowController implements ControllerV4{
    private MemberMemoryRepo repo = MemberMemoryRepo.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Model model) {
        List<Member> memberList = repo.findAll();

        ModelAndView modelAndView = new ModelAndView("v3/m-list");
        model.addAttribute("memberList", memberList);
        return "v4/m-list";
    }
}
