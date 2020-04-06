package ethan.demo.oauth2.userservice.controller;

import java.nio.charset.StandardCharsets;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {
	@GetMapping(value = "get")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Object get(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info(authentication.toString());
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)authentication.getDetails();
        String token = details.getTokenValue();
        return token;
    }
	
	@GetMapping(value = "jwt")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Object getJWT(Authentication authentication){
	    OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)authentication.getDetails();
	    String jwtToken = details.getTokenValue();
	    Claims claims = Jwts.parser()
	                .setSigningKey("sk".getBytes(StandardCharsets.UTF_8))
	                .parseClaimsJws(jwtToken)
	                .getBody();
	    return claims;
    }
}
