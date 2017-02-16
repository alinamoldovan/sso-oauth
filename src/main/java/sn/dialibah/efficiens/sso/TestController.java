package sn.dialibah.efficiens.sso;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * by osow on 15/02/17.
 * for neo9
 */
@RestController
@RequestMapping("/user")
public class TestController {

	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity getTest() {
		return ResponseEntity.ok("Test");
	}
}
