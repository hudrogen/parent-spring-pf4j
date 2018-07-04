package com.hudrogen.demo.fake;

import com.hudrogen.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InnerBaseController implements BaseController {

    @RequestMapping("/fakeCalc")
    public String calcMetric() {
        return "fake";
    }

    @RequestMapping("/fakeGetMetric")
    public String getMetric() {
        return "fake";
    }
}
