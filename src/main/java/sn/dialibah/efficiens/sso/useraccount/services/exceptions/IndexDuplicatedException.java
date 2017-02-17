package sn.dialibah.efficiens.sso.useraccount.services.exceptions;

import org.springframework.http.HttpStatus;
import sn.dialibah.efficiens.sso.common.exceptions.AbstractException;

/**
 * by osow on 17/02/17.
 * for neo9
 */
public class IndexDuplicatedException extends AbstractException {
	public IndexDuplicatedException(String message) {
		super(message);
	}

	@Override
	public HttpStatus getStatus() {
		return HttpStatus.CONFLICT;
	}

	@Override
	public String getErrorCode() {
		return "UNIQUE_INDEX_DUPLICATED";
	}
}
