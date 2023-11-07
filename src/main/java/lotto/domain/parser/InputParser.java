package lotto.domain.parser;

import java.util.List;

public abstract class InputParser {

    abstract List<Integer> parse(String input);

    abstract void validate(String input);

    protected void throwException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

    protected String removeSpaces(String input) {
        return input.replaceAll(" ", "");
    }
}
