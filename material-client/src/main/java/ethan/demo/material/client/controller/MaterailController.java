package ethan.demo.material.client.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MaterailController {

	@GetMapping("/getmaterial")
	public String getMaterial() {
		log.info(SecurityContextHolder.getContext().getAuthentication().toString());
		return "xx";
	}
}
