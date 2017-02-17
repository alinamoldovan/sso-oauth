package sn.dialibah.efficiens.sso.useraccount.services;

import sn.dialibah.efficiens.sso.useraccount.models.User;

/**
 * by osow on 17/02/17.
 * for neo9
 */
public interface IUserAccountService {


	/**
	 * Query database to add {@link User}
	 *
	 * @param user user with signup information
	 * @return {@link User} saved in database
	 */
	User create(User user);
}
