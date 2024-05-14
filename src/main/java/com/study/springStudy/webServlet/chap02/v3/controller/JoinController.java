package com.study.springStudy.webServlet.chap02.v3.controller;

import com.study.springStudy.webServlet.ModelAndView;
import com.study.springStudy.webServlet.View;

import java.util.Map;

public class JoinController implements ControllerV3{
    @Override
    public ModelAndView process(Map<String, String> paramMap) {
        return new ModelAndView("v3/reg_form");
    }
}
