package ethan.demo.oauth2.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import ethan.demo.oauth2.server.enhancer.JWTokenEnhancer;

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
	@Autowired
	public PasswordEncoder passwordEncoder;

	@Autowired
	public UserDetailsService ethanUserDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenStore tokenStore;

//	@Autowired
//	private TokenStore JwtTokenStore;

//	@Autowired
//	private JwtAccessTokenConverter jwtAccessTokenConverter;

	@Bean
	public TokenEnhancer jwtTokenEnhancer() {
		return new JWTokenEnhancer();
	}

	@Override
	public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//		TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
//		List<TokenEnhancer> enhancerList = new ArrayList<TokenEnhancer>();
//		enhancerList.add(jwtTokenEnhancer());
//		enhancerList.add(jwtAccessTokenConverter);
//		enhancerChain.setTokenEnhancers(enhancerList);
//		endpoints.authenticationManager(authenticationManager).userDetailsService(ethanUserDetailsService)
//				.tokenStore(tokenStore).accessTokenConverter(jwtAccessTokenConverter).tokenEnhancer(enhancerChain);

		endpoints.authenticationManager(authenticationManager).userDetailsService(ethanUserDetailsService)
		.tokenStore(tokenStore);

	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("material-client").secret(passwordEncoder.encode("other-secret-8888"))
				.authorizedGrantTypes("refresh_token", "authorization_code", "password")
				.accessTokenValiditySeconds(3600).scopes("all").redirectUris("http://localhost:9004/login").and()
				.withClient("merchant-client").secret(passwordEncoder.encode("other-secret-8888"))
				.authorizedGrantTypes("refresh_token", "authorization_code", "password")
				.accessTokenValiditySeconds(3600).scopes("all").redirectUris("http://localhost:9003/login").and()
				.withClient("user-client").secret(passwordEncoder.encode("user-secret-8888"))
				.authorizedGrantTypes("refresh_token", "authorization_code", "password")
				.accessTokenValiditySeconds(3600).scopes("all");

	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.allowFormAuthenticationForClients();
		security.checkTokenAccess("isAuthenticated()");
		security.tokenKeyAccess("permitAll()"); 
	}
}
