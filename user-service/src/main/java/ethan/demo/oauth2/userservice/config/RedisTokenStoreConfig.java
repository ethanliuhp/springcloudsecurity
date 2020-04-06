package ethan.demo.oauth2.userservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;


/**
 * ������Դ���������˴���tokenstore���Բ�Ҫ
 * @author Ethan
 *
 */
@Configuration
public class RedisTokenStoreConfig {
	@Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean("redistokenstore")
    @Primary
    public TokenStore redisTokenStore (){
        return new RedisTokenStore(redisConnectionFactory);
    }
}
