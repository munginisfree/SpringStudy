package com.study.springStudy.webServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModelAndView {
    private View view; //화면 처리
    private OurModel model; //화면에 필요한 데이터 처리

    public ModelAndView(String viewName) {
        this.view = new View(viewName);
        this.model = new OurModel();
    }

    // 화면 랜더링 기능 (forwarding or redirect)
    public void render(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.view.render(request, response);
    }

    // 모델에 JSP가 필요한 데이터를 담는 메서드
    public void addAttribute(String key, Object value) {
        this.model.addAttribute(key, value);
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public OurModel getModel() {
        return model;
    }

    public void setModel(OurModel model) {
        this.model = model;
    }
}
