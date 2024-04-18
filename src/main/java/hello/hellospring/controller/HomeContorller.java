package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeContorller {

    @GetMapping("/")
    public String home(){
        return "home";
    }

}
