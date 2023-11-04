package lotto.utils;

public interface Converter<S, I> {
    I convert(S target);
}
