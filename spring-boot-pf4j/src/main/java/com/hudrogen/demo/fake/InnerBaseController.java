package com.hudrogen.demo.fake;

import com.hudrogen.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
