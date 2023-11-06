package lotto.model.converter.StringToType;

public interface StringConverter<T> {
    T toType(String input);
}
