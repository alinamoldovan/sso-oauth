package sn.dialibah.efficiens.sso.common.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * by osow on 17/02/17.
 * for SIBusiness
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public abstract class EntityCore {
	@Id
	String id;
	LocalDateTime creationDateTime, lastModificationDateTime;
}
