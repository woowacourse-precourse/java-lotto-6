package lotto.util.converter;

public interface Converter<F,T>{
    T convert(F target);
}
