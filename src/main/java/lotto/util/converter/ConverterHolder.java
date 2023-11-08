package lotto.util.converter;

import java.util.ArrayList;
import java.util.List;

public class ConverterHolder {

    private static final List<Converter<?, ?>> converterHolder = new ArrayList<>();

    private ConverterHolder() { }

    public static void setConverters(List<Converter<?, ?>> converters) {
        converterHolder.addAll(converters);
    }

    public static <T> T convert(Object target, Class<?> convertTo) {
        for (Converter converter : converterHolder) {
            if (converter.supports(target, convertTo)) {
                return (T) converter.convert(target);
            }
        }
        throw new IllegalArgumentException();
    }

}
