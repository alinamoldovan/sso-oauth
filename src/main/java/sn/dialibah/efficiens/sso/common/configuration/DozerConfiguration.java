package sn.dialibah.efficiens.sso.common.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sn.dialibah.efficiens.sso.common.helpers.DozerBeanMappingHelper;
import sn.dialibah.efficiens.sso.common.helpers.LocalDateTimeCoverter;
import sn.dialibah.efficiens.sso.useraccount.entities.UserAccountEntity;
import sn.dialibah.efficiens.sso.useraccount.models.User;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * by osow on 17/02/17.
 * for neo9
 */
@Configuration
public class DozerConfiguration {
	@Bean
	public DozerBeanMapper getDozerBeanMapper() {
		final DozerBeanMapper mapper = new DozerBeanMapper();

		mapper.addMapping(DozerBeanMappingHelper.buildClassMapper(
						User.class, UserAccountEntity.class,
						Stream.of("creationDateTime", "lastModificationDateTime").collect(Collectors.toList()),
						LocalDateTimeCoverter.class
		));
		return mapper;
	}
}
