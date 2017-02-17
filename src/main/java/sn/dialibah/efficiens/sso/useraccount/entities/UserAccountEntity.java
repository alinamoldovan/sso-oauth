package sn.dialibah.efficiens.sso.useraccount.entities;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import sn.dialibah.efficiens.sso.common.models.EntityCore;

/**
 * by osow on 17/02/17.
 * for neo9
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document(collection = "userAccounts")
public class UserAccountEntity extends EntityCore {

	@Indexed(sparse = true, unique = true)
	private String username;

	@Indexed(sparse = true, unique = true)
	private String email;

	private String firstName, lastName, hashedPassword;
}
