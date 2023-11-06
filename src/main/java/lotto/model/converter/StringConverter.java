package lotto.model.converter;

public interface StringConverter<T> {
    T toType(String input);
}
