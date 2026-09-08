package com.likelion.springsession_hw.Myname;

import com.likelion.springsession_hw.greeting.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MynameController {

    @GetMapping("/my-name")
    public String myName(){
        return "이승우";
    }

}
