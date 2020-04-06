package ethan.demo.oauth2.userservice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("accesspolicy")
@Slf4j
public class AccessPolicy {
	public boolean check(Authentication authentication, HttpServletRequest request) {
		log.info(request.getRequestURI());
	    OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)authentication.getDetails();
	    String jwtToken = details.getTokenValue();
	    log.info(jwtToken);
		if (request.getRequestURI().equalsIgnoreCase("/jwt")) {
			log.info("access denied");
			return false;
		}
		
//		Object principal = authentication.getPrincipal();
//		if (principal != null && principal instanceof UserDetails) {
//			
//			System.out.println(((UserDetails) principal).getAuthorities());
//			log.info(request.getRequestURI());
//			if(request.getRequestURI()!="/jwt")
//				return false;
//			return true;
//		}
		return true;
	}
}
