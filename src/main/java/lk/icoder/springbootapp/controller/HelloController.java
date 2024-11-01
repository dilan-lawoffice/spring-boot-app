package lk.icoder.springbootapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {
    
    @GetMapping("/healthCheck/{id}")
    public String healthCheck(@PathVariable String id) {
        System.out.println(id);
        return "working...";
    }
}
