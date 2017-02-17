package sn.dialibah.efficiens.sso.useraccount.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import sn.dialibah.efficiens.sso.useraccount.entities.UserAccountEntity;

import java.util.Optional;

/**
 * by osow on 17/02/17.
 * for SIBusiness
 */
public interface UserAccountRepository extends PagingAndSortingRepository<UserAccountEntity, String> {
	Optional<UserAccountEntity> findByUsername(String username);

}
