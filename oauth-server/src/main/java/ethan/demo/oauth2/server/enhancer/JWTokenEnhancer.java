package ethan.demo.oauth2.server.enhancer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JWTokenEnhancer implements TokenEnhancer {

	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		// TODO Auto-generated method stub
		
		String username= authentication.getName();
		String user  =  authentication.getPrincipal().toString();
		log.info(username);
		log.info(user);

		//System.out.println(username);
		Map<String, Object> info = new HashMap<String, Object>();
		EnhancerInfo enhancerInfo= new EnhancerInfo();
		enhancerInfo.setAddress("ºþ±±ÏåÑô");
		enhancerInfo.setEmail("2832230062@qq.com");
        info.put("otherinfo", enhancerInfo);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
	}

}
