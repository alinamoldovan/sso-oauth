package sn.dialibah.efficiens.sso.useraccount.services;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sn.dialibah.efficiens.sso.useraccount.UserController;
import sn.dialibah.efficiens.sso.useraccount.entities.UserAccountEntity;
import sn.dialibah.efficiens.sso.useraccount.models.User;
import sn.dialibah.efficiens.sso.useraccount.repositories.UserAccountRepository;
import sn.dialibah.efficiens.sso.useraccount.services.exceptions.IndexDuplicatedException;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * by osow on 17/02/17.
 * for SIBusiness
 */
@Service
public class UserAccountService  implements IUserAccountService {

	public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	public static final String LOG_HEADER = "[SSO][USER ACCOUNT SERVICE]";

	@Autowired
	private DozerBeanMapper mapper;

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User create(User user) {
		LOGGER.debug("{} create user account -> {}", LOG_HEADER, user);
		final UserAccountEntity userAccountEntity = this.mapper.map(user, UserAccountEntity.class);
		LocalDateTime currentDate = LocalDateTime.now();
		userAccountEntity.setCreationDateTime(currentDate);
		userAccountEntity.setLastModificationDateTime(currentDate);
		userAccountEntity.setHashedPassword(this.passwordEncoder.encode(user.getPassword()));
		LOGGER.debug("{} user account to save -> {}", LOG_HEADER, userAccountEntity);
		UserAccountEntity saved;
		try {
			saved = this.userAccountRepository.save(userAccountEntity);
		} catch (DuplicateKeyException e) {
			throw new IndexDuplicatedException(String.format("Index Duplicated for user %s", user));
		}

		return this.mapper.map(saved, User.class);
	}

	@Override
	public Optional<User> getByUsername(String username) {
		LOGGER.debug("{} get user with username -> {}", LOG_HEADER, username);
		final Optional<UserAccountEntity> maybeUserEntity  = userAccountRepository.findByUsername(username);
		if(maybeUserEntity.isPresent()){
			return Optional.ofNullable(mapper.map(maybeUserEntity.get(), User.class));
		}
		return Optional.ofNullable(maybeUserEntity
				.map(userAccountEntity -> mapper.map(userAccountEntity, User.class))
				.orElse(null));
	}


}
