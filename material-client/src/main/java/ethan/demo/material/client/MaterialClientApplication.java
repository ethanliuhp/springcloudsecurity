package ethan.demo.material.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@EnableOAuth2Sso
@SpringBootApplication
public class MaterialClientApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MaterialClientApplication.class, args);
	}

}
