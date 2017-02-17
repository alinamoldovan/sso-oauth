package sn.dialibah.efficiens.sso.useraccount.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.dialibah.efficiens.sso.common.models.EntityCore;

/**
 * by osow on 16/02/17.
 * for neo9
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends EntityCore {
	private String username, email, firstName, lastName, password;
}
