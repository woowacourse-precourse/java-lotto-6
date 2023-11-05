package lotto.util;

import java.util.Arrays;
import java.util.List;

public abstract class InputList<T> implements InputValidator {
    protected final List<T> list;

    protected InputList(String input) {
        List<String> stringList = toList(input);
        checkBlank(stringList);
        list = convertElements(stringList);
        validate();
    }

    private void checkBlank(List<String> stringList) {
        for (String element:stringList) {
            if (element.isBlank()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private List<String> toList(String input) {
        input = input.replaceAll(" ", "");
        return Arrays.stream(input.split(",")).toList();
    }

    public abstract void validate();
    protected abstract List<T> convertElements(List<String> input);
}
