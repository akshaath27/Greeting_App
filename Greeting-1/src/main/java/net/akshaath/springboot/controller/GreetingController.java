package net.akshaath.springboot.controller;



import net.akshaath.springboot.dto.GreetingRequest;
import net.akshaath.springboot.entity.Greeting-1;
import net.akshaath.springboot.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @PostMapping("/greet")
    public String greet(@RequestBody GreetingRequest request) {
        Greeting greeting = greetingService.createGreeting(request.getFirstName(), request.getLastName());
        return greeting.getMessage();
    }
}