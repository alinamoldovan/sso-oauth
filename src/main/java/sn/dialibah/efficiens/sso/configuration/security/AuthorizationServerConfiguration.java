package sn.dialibah.efficiens.sso.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * by osow on 15/02/17.
 * for neo9
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	@Qualifier("authenticationManagerBean")
	AuthenticationManager authenticationManager;

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private UserApprovalHandler userApprovalHandler;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
						.withClient("clientId")
						.authorizedGrantTypes("implicit")
						.scopes("read")
						.autoApprove(true)
						.and()
						.withClient("cliendIdPwd")
						.secret("secret")
						.authorizedGrantTypes("password", "authorization_code", "refresh_token")
						.scopes("read");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(this.tokenStore)
						.userApprovalHandler(this.userApprovalHandler)
						.authenticationManager(this.authenticationManager);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()")
						.checkTokenAccess("isAuthenticated()");
	}
}
