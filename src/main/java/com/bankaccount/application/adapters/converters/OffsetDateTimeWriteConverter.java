package com.bankaccount.application.adapters.converters;

import java.time.OffsetDateTime;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


/**
 * A converter converts a source object of type {@code OffsetDateTime} to a target of type {@code Date}.
 * 
 * @author c.cordier
 */
public class OffsetDateTimeWriteConverter implements Converter<OffsetDateTime, Date> {

	@Override
	public Date convert(OffsetDateTime offsetDateTime) {
		return Date.from(offsetDateTime.toInstant());
	}
}
