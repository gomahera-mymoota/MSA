package com.springtour.example.ch03.domain.format;

public interface Formatter<T> {

    String of(T target);

}
