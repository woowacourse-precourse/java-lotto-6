package lotto.util.convertor;

import java.util.function.Function;

public class StringConvertor<T> implements Convertor<T> {
    private final Function<String, T> stringToConverter;

    public StringConvertor(Function<String, T> stringToConverter) {
        this.stringToConverter = stringToConverter;
    }

    @Override
    public T convert(String string) {
        return convertInputValue(string);
    }

    public T convertInputValue(String inputValue) {
        return stringToConverter.apply(inputValue);
    }
}
