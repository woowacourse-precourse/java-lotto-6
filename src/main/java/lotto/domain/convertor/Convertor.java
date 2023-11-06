package lotto.domain.convertor;

public interface Convertor<T> {
    T convert(String text);
}
