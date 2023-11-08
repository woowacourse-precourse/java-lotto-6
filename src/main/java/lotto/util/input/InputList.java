package lotto.util.input;

import static lotto.util.constants.Strings.BLANK;
import static lotto.util.constants.Strings.COMMA;
import static lotto.util.constants.Strings.NULL_STRING;
import static lotto.util.exception.ErrorMessage.BLANK_ELEMENT;

import java.util.Arrays;
import java.util.List;
import lotto.util.exception.LottoException;

public abstract class InputList<T> implements InputValidator {
    protected final List<T> list;

    protected InputList(final String input) {
        List<String> stringList = toList(input);
        checkBlank(stringList);
        list = convertElements(stringList);
        validate();
    }

    private void checkBlank(final List<String> stringList) {
        for (String element:stringList) {
            if (element.isEmpty()) {
                throw LottoException.of(BLANK_ELEMENT);
            }
        }
    }

    private List<String> toList(String input) {
        input = input.replaceAll(BLANK.getString(), NULL_STRING.getString());
        return Arrays.stream(input.split(COMMA.getString())).toList();
    }

    public abstract void validate();
    protected abstract List<T> convertElements(List<String> input);
}
