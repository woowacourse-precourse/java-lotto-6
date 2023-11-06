package lotto.converter;

@FunctionalInterface
public interface Converter<S, T> {

    T convert(S source);
}
