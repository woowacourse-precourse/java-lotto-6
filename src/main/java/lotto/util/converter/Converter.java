package lotto.util.converter;

public interface Converter<F, T>  {
    boolean supports(Object from, Class<?> to);

    T convert(F target);
}
