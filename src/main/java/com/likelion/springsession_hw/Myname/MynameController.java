package com.likelion.springsession_hw.Myname;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MynameController {

    @GetMapping("/my-name")
    public String myName(){
        return "이승우";
    }

}
