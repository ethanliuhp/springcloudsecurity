package ethan.demo.oauth2.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UserServiceApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@GetMapping("/test")
    public String helloworld() {
    	return "hellow world";
    }
}
