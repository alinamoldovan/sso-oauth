package sn.dialibah.efficiens.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableAutoConfiguration
public class SsoOauthApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SsoOauthApplication.class, args);
	}
}
