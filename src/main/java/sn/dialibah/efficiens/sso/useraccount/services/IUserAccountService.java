package sn.dialibah.efficiens.sso.useraccount.services;

import sn.dialibah.efficiens.sso.useraccount.models.User;

import java.util.Optional;

/**
 * by osow on 17/02/17.
 * for SIBusiness
 */
public interface IUserAccountService {


	/**
	 * Query database to add {@link User}
	 *
	 * @param user user with signup information
	 * @return {@link User} saved in database
	 */
	User create(User user);

	/**
	 * Query the database to get a User with the given username
	 * @param username to find
	 * @return {@link User} if exist
	 */
	Optional<User> getByUsername(String username);


}
