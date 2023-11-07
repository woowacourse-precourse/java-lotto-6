package lotto.converter;

@FunctionalInterface
public interface Converter<T, S> {

    T convert(S source);

}
