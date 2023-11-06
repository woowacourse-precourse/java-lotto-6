package lotto.model.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface StringConverter<T> {
    T toType(String input);

    default List<T> toTypeList(List<String> inputList) {
        return inputList.stream()
                .map(this::toType)
                .collect(Collectors.toList());
    }
}
