package com.springtour.example.ch03.domain.format;

import com.springtour.example.ch03.domain.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter implements Formatter<Date> {

    private SimpleDateFormat sdf;

    public DateFormatter(String pattern) {
        if (!StringUtils.hasLength(pattern)) {      // in favor of StringUtils.isEmpty()
            throw new IllegalArgumentException("Pattern is empty");
        }

        this.sdf = new SimpleDateFormat(pattern);
    }

    @Override
    public String of(Date target) {
        return null;
    }

    public Date parse(String dateString) throws ParseException {
        return sdf.parse(dateString);
    }
}
