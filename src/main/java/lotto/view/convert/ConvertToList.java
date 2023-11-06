package lotto.view.convert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.config.exception.ExceptionType;
import lotto.config.exception.InputException;

public class ConvertToList {
    private final List<Integer> value;

    public static ConvertToList from(String value) {
        return new ConvertToList(value);
    }

    private ConvertToList(String value) {
        String[] values = value.split(",");

        validateInput(values);

        this.value = Arrays.stream(values)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private void validateInput(String[] values) {
        if(isWhiteSpace(values)){
            throw new InputException(ExceptionType.ERROR_CONVERT_TO_LIST_WHITESPACE);
        }
    }

    private boolean isWhiteSpace(String[] values) {
        return Arrays.stream(values)
                .anyMatch(value -> value.equals(""));
    }

    public List<Integer> getValue() {
        return Collections.unmodifiableList(this.value);
    }
}
