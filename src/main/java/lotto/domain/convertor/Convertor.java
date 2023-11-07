package lotto.domain.convertor;

public interface Convertor<S, T> {
    T convert(S value);
}
