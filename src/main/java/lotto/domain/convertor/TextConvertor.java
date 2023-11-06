package lotto.domain.convertor;

import java.util.function.Function;

public class TextConvertor<T> implements Convertor<T> {
    private final Function<String, T> textConvertor;

    public TextConvertor(Function<String, T> textConvertor) {
        this.textConvertor = textConvertor;
    }

    @Override
    public T convert(String text) {
        return convertInputValue(text);
    }

    public T convertInputValue(String inputValue) {
        return textConvertor.apply(inputValue);
    }
}
