package lotto.model.converter;

import static lotto.util.ExceptionMessage.INVALID_TYPE;

import java.util.List;

public class IntegerConverter implements StringConverter<Integer> {
    @Override
    public Integer toType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INVALID_TYPE.getMessage());
        }
    }

    @Override
    public List<Integer> toTypeList(List<String> inputList) {
        return StringConverter.super.toTypeList(inputList);
    }
}
