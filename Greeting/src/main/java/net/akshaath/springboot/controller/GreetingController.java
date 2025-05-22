package net.akshaath.springboot.controller;

import net.akshaath.springboot.entity.Greeting;
import net.akshaath.springboot.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/greeting")
public class GreetingController {
	
	private final GreetingService greetingService;
    
    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @PostMapping("/message")
    public Greeting saveCustomMessage(@RequestBody Greeting greetingMessage) {
        return greetingService.generateGreeting(greetingMessage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable Long id) {
        return greetingService.findGreetingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetingMessages();
    }
    @PutMapping("/update/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestParam String message) {
        return greetingService.updateGreetingMessage(id, message);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreetingMessage(id);
        return "Greeting message with ID " + id + " has been deleted.";
    }

}