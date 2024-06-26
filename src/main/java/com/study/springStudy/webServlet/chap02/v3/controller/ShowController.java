package com.study.springStudy.webServlet.chap02.v3.controller;

import com.study.springStudy.webServlet.MemberMemoryRepo;
import com.study.springStudy.webServlet.ModelAndView;
import com.study.springStudy.webServlet.entity.Member;

import java.util.List;
import java.util.Map;

public class ShowController implements ControllerV3 {

    private MemberMemoryRepo repo = MemberMemoryRepo.getInstance();

    @Override
    public ModelAndView process(Map<String, String> paramMap) {
        List<Member> memberList = repo.findAll();

        ModelAndView modelAndView = new ModelAndView("v3/m-list");
        modelAndView.addAttribute("memberList", memberList);
        return modelAndView;
    }
}
