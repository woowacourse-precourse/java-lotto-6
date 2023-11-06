package lotto.controller.converter;

public interface Converter<T> {
    public T convert(String input);
}
