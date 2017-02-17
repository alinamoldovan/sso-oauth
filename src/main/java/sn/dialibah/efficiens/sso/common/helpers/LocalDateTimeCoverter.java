package sn.dialibah.efficiens.sso.common.helpers;

import org.dozer.DozerConverter;

import java.time.LocalDateTime;

/**
 * by osow on 17/02/17.
 * for neo9
 */
public class LocalDateTimeCoverter extends DozerConverter<LocalDateTime, LocalDateTime> {

	public LocalDateTimeCoverter() {
		super(LocalDateTime.class, LocalDateTime.class);
	}

	@Override
	public LocalDateTime convertTo(LocalDateTime source, LocalDateTime destination) {
		return source;
	}

	@Override
	public LocalDateTime convertFrom(LocalDateTime source, LocalDateTime destination) {
		return convertTo(source, destination);
	}
}
