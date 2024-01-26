package com.springtour.example.ch03.config;

import com.springtour.example.ch03.domain.format.Formatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public class DateFormatter implements Formatter<Date> {
    private SimpleDateFormat sdf;

    public DateFormatter(String pattern) {
        log.info("DateFormatter.DateFormatter : {}", pattern.hashCode());
        this.sdf = new SimpleDateFormat(pattern);
    }

    @Override
    public String of(Date target) {
        return sdf.format(target);
    }
}
