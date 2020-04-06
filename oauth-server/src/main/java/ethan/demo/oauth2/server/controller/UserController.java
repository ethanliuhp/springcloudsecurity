package ethan.demo.oauth2.server.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	@GetMapping("/userinfo")
	public Principal getUserInfo(Principal user) {
		log.info(user.toString());
		log.info("////////////////////////////////////////////////////////////////////////"
				+ "///////////////////////////////////////////////////////////////////////");
		return user;
	}
}
