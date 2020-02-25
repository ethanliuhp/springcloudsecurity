package ethan.demo.merchant.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private OAuth2RestOperations restTemplate;
	
	@GetMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication) {
        return authentication;
    }
	
	@GetMapping("/getjwt")
	public Object getJWT(){
		return restTemplate.getForObject("http://localhost:9002/jwt", String.class);
	}
}
