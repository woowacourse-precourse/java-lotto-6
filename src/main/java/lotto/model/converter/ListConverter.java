package lotto.model.converter;

import java.util.Arrays;
import java.util.List;

public class ListConverter implements StringConverter<List<String>> {
    @Override
    public List<String> toType(String input) {
        return Arrays.stream(input.split(",", -1)).toList();
    }
}
