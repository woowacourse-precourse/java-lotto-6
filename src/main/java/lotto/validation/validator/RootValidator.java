package lotto.validation.validator;

import static lotto.property.ErrorProperty.*;
import static lotto.property.LottoProperty.LOTTO_END;
import static lotto.property.LottoProperty.LOTTO_START;

public abstract class RootValidator {

    public static void valueIsEmpty(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException(VALUE_IS_EMPTY.toString());
        }
    }

    public static void valueContainsSpace(String value) {
        String compareTarget = value.replaceAll(" ", "");
        if (!compareTarget.equals(value)) {
            throw new IllegalArgumentException(VALUE_CONTATIN_SPACE.toString());
        }
    }

    public static void valueIsNumeric(String value) {
        if (!value.matches("\\d+")) {
            throw new IllegalArgumentException(VALUE_IS_NOT_NUMERIC.toString());
        }
    }

    public static void valueIsCorrectRange(String vlaue) {
        int number = Integer.parseInt(vlaue);
        if (number < LOTTO_START || number > LOTTO_END) {
            throw new IllegalArgumentException(NUMBER_IS_NOT_CORRECTLY_RANGE.toString());
        }
    }
}
