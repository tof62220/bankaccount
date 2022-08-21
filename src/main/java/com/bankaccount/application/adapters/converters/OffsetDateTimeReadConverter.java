package com.bankaccount.application.adapters.converters;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


/**
 * A converter converts a source object of type {@code Date} to a target of type {@code OffsetDateTime}.
 * 
 * @author c.cordier
 */
public class OffsetDateTimeReadConverter implements Converter<Date, OffsetDateTime> {

	@Override
	public OffsetDateTime convert(Date date) {
		return date.toInstant().atZone(ZoneOffset.UTC).toOffsetDateTime();
	}

}
