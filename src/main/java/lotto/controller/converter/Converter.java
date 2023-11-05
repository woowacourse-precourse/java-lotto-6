package lotto.controller;

public interface Converter<T> {
    public T convert(String input);
}
