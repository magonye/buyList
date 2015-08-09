package com.mike.buyList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mike on 8/8/15.
 */
@Controller
public class SampleController {

    @RequestMapping("/sample")
    @ResponseBody
    public String hello(){
        return "Hello Web Services";
    }
}
