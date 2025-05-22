package net.akshaath.springboot.service;
import java.util.Optional;
import net.akshaath.springboot.entity.Greeting;
import net.akshaath.springboot.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public Greeting generateGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }
   

    public Optional<Greeting> findGreetingById(Long id) {
        return greetingRepository.findById(id);
    }
    public List<Greeting> getAllGreetingMessages(){
    	return greetingRepository.findAll();
    }
    public Greeting updateGreetingMessage(Long id, String newMessage) {
        Optional<Greeting> optionalMessage = greetingRepository.findById(id);

        if (optionalMessage.isPresent()) {
            Greeting message = optionalMessage.get();
            message.setMessage(newMessage);
            return greetingRepository.save(message);
        } else {
            throw new RuntimeException("Greeting with ID " + id + " not found.");
        }
    }
    public void deleteGreetingMessage(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
        } else {
            throw new RuntimeException("Greeting with ID " + id + " not found.");
        }
    }
}
