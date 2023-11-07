package lotto.converter;

public interface Converter<T, S> {

    T convert(S source);

}
