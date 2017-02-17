package sn.dialibah.efficiens.sso.useraccount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sn.dialibah.efficiens.sso.useraccount.models.User;
import sn.dialibah.efficiens.sso.useraccount.services.IUserAccountService;

/**
 * by osow on 16/02/17.
 * for neo9
 */
@RestController
@RequestMapping("users")
public class UserController {

	public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	public static final String LOG_HEADER = "[SSO][USER ACCOUNT CONTROLLER]";

	@Autowired
	private IUserAccountService userAccountService;

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		LOGGER.debug("{} add new user {}", LOG_HEADER, user);
		return new ResponseEntity<>(this.userAccountService.create(user), HttpStatus.OK);
	}

}
